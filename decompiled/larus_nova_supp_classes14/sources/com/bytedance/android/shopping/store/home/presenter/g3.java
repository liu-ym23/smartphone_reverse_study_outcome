package com.bytedance.android.shopping.store.home.presenter;

import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.shopping.store.home.entity.ECTopSearchInfo;
import com.bytedance.android.shopping.store.home.view.ECStoreCollapsibleTextView;
import com.bytedance.android.shopping.store.home.view.SearchHotWordFlipperAdapter;
import com.bytedance.android.shopping.store.repository.vo.SearchSuggestWord;
import com.bytedance.android.ui.base.widget.viewflipper.ECViewFlipper;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class g3<T> implements Observer {
    public final /* synthetic */ ECShopTopBarSearchPresenterV2 a;

    public g3(ECShopTopBarSearchPresenterV2 r1) {
        this.a = r1;
    }

    public final void onChanged(Object r10) {
        ECTopSearchInfo r11 = (ECTopSearchInfo) r10;
        ECShopTopBarSearchPresenterV2 r0 = this.a;
        r0.getClass();
        List<SearchSuggestWord> r1 = null;
        if (r11 == null) goto L9;
        List<SearchSuggestWord> r2 = r11.getWords();
        if (r2 == null) goto L9;
        SearchSuggestWord r3 = (SearchSuggestWord) CollectionsKt.firstOrNull(r2);
        if (r3 == null) goto L9;
        String r4 = r3.getWord();
    L11:
        if (r4 != null) goto L13;
    L16:
        boolean r5 = true;
    L18:
        if (r5 == false) goto L20;
        r4 = th.a.e(r0.u().c(), true).getString(2131895925);
    L20:
        com.bytedance.android.ec.store.view.q r6 = new com.bytedance.android.ec.store.view.q(r4);
        com.bytedance.android.ec.store.view.q.a r7 = new com.bytedance.android.ec.store.view.q.a(r6.length(), ((Number) r0.B.getFirst()).intValue(), ((Number) r0.B.getSecond()).intValue());
        Intrinsics.checkNotNullParameter(r7, "span");
        r6.a.add(r7);
        ECStoreCollapsibleTextView r8 = this.a.u;
        if (r8 == null) goto L34;
        Intrinsics.checkNotNullParameter(r6, "string");
        r8.m = r6;
        SimpleDraweeView r9 = r8.c;
        if (r9 == null) goto L25;
        r9.setImageResource(2131248085);
    L25:
        com.bytedance.android.ec.store.view.q r12 = r8.m;
        if (r12 == null) goto L28;
        r12.a(0.0f);
    L28:
        View r13 = r8.f;
        if ((r13 instanceof TextView) == true) goto L31;
        r13 = null;
    L31:
        TextView r14 = (TextView) r13;
        if (r14 == null) goto L34;
        r14.setText(r8.m);
    L34:
        final ECShopTopBarSearchPresenterV2 r15 = this.a;
        if (r11 == null) goto L37;
        r1 = r11.getCarouselWords();
    L37:
        r15.getClass();
        ArrayList r16 = new ArrayList();
        List<SearchSuggestWord> r17 = r1;
        if (r17 != null) goto L40;
    L43:
        boolean r18 = true;
    L44:
        if (r18 == true) goto L47;
        r16.addAll(r17);
    L47:
        if (r16.isEmpty() == false) goto L49;
        SearchSuggestWord r19 = new SearchSuggestWord();
        r19.setWord(th.a.e(r15.u().c(), true).getString(2131895925));
        r19.setDefaultWord(true);
        Unit r20 = Unit.INSTANCE;
        r16.add(r19);
    L49:
        SearchHotWordFlipperAdapter r21 = r15.z;
        r21.getClass();
        Intrinsics.checkNotNullParameter(r16, "dataSet");
        r21.a = r16;
        r21.notifyDataSetChanged();
        ECViewFlipper r22 = r15.x;
        if (r22 == null) goto L53;
        r22.stopFlipping();
    L53:
        if (r16.size() <= 1) goto L62;
        ECViewFlipper r23 = r15.x;
        if (r23 == null) goto L57;
        r23.startFlipping();
    L57:
        r15.T().getCurrentTabLiveData().a(r15.W(), new f3(r15), false);
        Fragment r24 = r15.h;
        if (r24 == null) goto L62;
        Lifecycle r25 = r24.getLifecycle();
        if (r25 == null) goto L62;
        r25.addObserver(new ECShopTopBarSearchPresenterV2$initFragmentLifecycleListener$2(r15));
    L62:
        SearchSuggestWord r110 = (SearchSuggestWord) CollectionsKt.firstOrNull(r16);
        if (r110 == null) goto L65;
        r15.v0(r110);
    L65:
        ECShopTopBarSearchPresenterV2 r111 = this.a;
        ECShopTopBarSearchPresenterV2.s0(r111, com.bytedance.android.shopping.extensions.k.d((Float) r111.T().getCollapseFactor().getValue()));
        return;
    L40:
        if (r17.isEmpty() == true) goto L43;
        r18 = false;
        goto L44
    L13:
        if (r4.length() == 0) goto L16;
        r5 = false;
    L9:
        r4 = null;
        goto L11
    }
}
