package com.bytedance.android.shopping.anchorv4.voavhs.baseinfo;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.ec.model.response.anchorv3.GroupAvatarTimeStruct;
import com.bytedance.android.ec.model.response.anchorv3.GroupInfo;
import com.facebook.drawee.view.SimpleDraweeView;
import io.reactivex.CompletableEmitter;
import io.reactivex.CompletableOnSubscribe;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class i implements CompletableOnSubscribe {
    public final /* synthetic */ ViewGroup a;
    public final /* synthetic */ GroupInfo b;

    public i(ViewGroup r1, GroupInfo r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void subscribe(CompletableEmitter r10) {
        Intrinsics.checkNotNullParameter(r10, "emitter");
    L39:
        th = move-exception;
        r10.onError(th);
        return;
    L4:
        if (this.a.getChildCount() <= 0) goto L6;
        this.a.removeAllViews();     // Catch: Throwable -> L39
    L6:
        List r0 = this.b.getAvatars();     // Catch: Throwable -> L39
        List r1 = r0;     // Catch: Throwable -> L39
        if (r1 != null) goto L9;
    L12:
        boolean r2 = true;
    L13:
        if (r2 == false) goto L15;
        List r3 = CollectionsKt.listOf(new GroupAvatarTimeStruct("https://p26-item.ecombdimg.com/tos-cn-i-5mmsx3fupr/2b7995a8c4a1a9776150d9cb2461ddae.png~tplv-5mmsx3fupr-origin-png.png", 0, 2, null));     // Catch: Throwable -> L39
    L16:
        List r4 = r3;     // Catch: Throwable -> L39
        ArrayList r5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));     // Catch: Throwable -> L39
        Iterator r6 = r4.iterator();     // Catch: Throwable -> L39
        int r7 = 0;
    L18:
        if (r6.hasNext() == false) goto L33;
        Object r8 = r6.next();     // Catch: Throwable -> L39
        int r9 = r7 + 1;     // Catch: Throwable -> L39
        if (r7 >= 0) goto L22;
        CollectionsKt.throwIndexOverflow();     // Catch: Throwable -> L39
    L22:
        Context r11 = this.a.getContext();     // Catch: Throwable -> L39
        SimpleDraweeView r12 = l.a(r11, (GroupAvatarTimeStruct) r8);     // Catch: Throwable -> L39
        if (r7 != 0) goto L25;
        int r13 = 0;
    L26:
        ViewGroup.LayoutParams r14 = r12.getLayoutParams();     // Catch: Throwable -> L39
        if ((r14 instanceof ViewGroup.MarginLayoutParams) == true) goto L29;
        r14 = null;
    L29:
        ViewGroup.MarginLayoutParams r15 = (ViewGroup.MarginLayoutParams) r14;     // Catch: Throwable -> L39
        if (r15 == null) goto L32;
        r15.leftMargin = r13;     // Catch: Throwable -> L39
    L32:
        r5.add(r12);     // Catch: Throwable -> L39
        r7 = r9;
        goto L18
    L25:
        r13 = vf4.a.b(-8);     // Catch: Throwable -> L39
        goto L26
    L33:
        Iterator r16 = r5.iterator();     // Catch: Throwable -> L39
    L35:
        if (r16.hasNext() == false) goto L37;
        View r17 = (View) r16.next();     // Catch: Throwable -> L39
        this.a.addView(r17);     // Catch: Throwable -> L39
        goto L35
    L37:
        r10.onComplete();     // Catch: Throwable -> L39
        return;
    L15:
        r3 = CollectionsKt.take(r0, 5);     // Catch: Throwable -> L39
        goto L16
    L9:
        if (r1.isEmpty() == true) goto L12;
        r2 = false;
        goto L13
    }
}
