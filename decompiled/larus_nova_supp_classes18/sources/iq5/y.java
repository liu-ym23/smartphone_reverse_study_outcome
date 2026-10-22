package iq5;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.list.selector.SelectorConfig;
import com.bytedance.ee.bear.list.selector.SpaceSelectorBean;
import com.bytedance.ee.bear.route.PostCard;
import com.bytedance.ee.bear.route.RouteBean;
import com.bytedance.ee.bear.wikiv2.selector.SelectorActivity;
import com.bytedance.ee.bear.wikiv2.selector.WikiSelectorBean;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class y {
    public static final /* synthetic */ int a = 0;

    static {
    }

    @JvmStatic
    public static final void a(Context r3, SelectorConfig r4, td5.f r5, SpaceSelectorBean r6, WikiSelectorBean r7) {
        tt5.a.h("SelectorActivityNavigationManager", "navigateToSelectorActivityByActivity");
        PostCard r0 = ((com.bytedance.ee.bear.route.h) org.koin.java.a.c(com.bytedance.ee.bear.route.h.class, null, null, 6)).w2("/selector/activity");
        if (r4 == null) goto L5;
        r0.o("extra_config", r4);
    L5:
        if (r6 == null) goto L7;
        r0.o("extra_space_bean", r6);
    L7:
        if (r7 == null) goto L9;
        r0.o("extra_wiki_bean", r7);
    L9:
        if (r3 == null) goto L11;
        r0.d(r3);
    L11:
        if (r5 == null) goto L13;
        Intrinsics.checkNotNull(r0);
        z.a(r5, r0);
    L13:
        r0.e();
    }

    @JvmStatic
    public static final void b(Fragment r8, SelectorConfig r9, td5.f r10, SpaceSelectorBean r11, WikiSelectorBean r12) {
        Intrinsics.checkNotNullParameter(r8, "fragment");
        Integer r4 = null;
        if (ForsetiHelper.s(r8) == false) goto L22;
        tt5.a.h("SelectorActivityNavigationManager", "navigateToSelectorActivityByFragmentByForseti");
        RouteBean r0 = new RouteBean();
        r0.a(r8);
        r0.q = RouteBean.DestStyle.FLOAT;
        if (r10 == null) goto L7;
        boolean r5 = r10.h;
    L8:
        r0.t = r5;
        PostCard r1 = ((com.bytedance.ee.bear.route.h) org.koin.java.a.c(com.bytedance.ee.bear.route.h.class, null, null, 6)).yd("/selector/activity", r0);
        if (r9 == null) goto L11;
        r1.o("extra_config", r9);
    L11:
        if (r11 == null) goto L13;
        r1.o("extra_space_bean", r11);
    L13:
        if (r12 == null) goto L15;
        r1.o("extra_wiki_bean", r12);
    L15:
        Context r13 = r8.getContext();
        if (r13 == null) goto L18;
        r1.d(r13);
    L18:
        if (r10 == null) goto L20;
        Intrinsics.checkNotNull(r1);
        z.a(r10, r1);
    L20:
        r1.e();
        return;
    L7:
        r5 = false;
        goto L8
    L22:
        tt5.a.h("SelectorActivityNavigationManager", "navigateToSelectorActivityByFragment");
        FragmentActivity r2 = r8.getActivity();
        if (r2 != null) goto L26;
        tt5.a.k("SelectorActivityNavigationManager", "navigateToSelectorActivityByFragment fail");
        return;
    L26:
        Intent r6 = new Intent(r2, SelectorActivity.class);
        if (r9 == null) goto L29;
        r6.putExtra("extra_config", r9);
    L29:
        if (r11 == null) goto L31;
        r6.putExtra("extra_space_bean", r11);
    L31:
        if (r12 == null) goto L33;
        r6.putExtra("extra_wiki_bean", r12);
    L33:
        if (r10 == null) goto L52;
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r6, "intent");
        Integer r14 = r10.a;
        if (r14 == null) goto L37;
        r6.putExtra("EXTRA_PAGE_MODE", r14.intValue());
    L37:
        Integer r15 = r10.b;
        if (r15 == null) goto L40;
        r6.putExtra("createDocumentType", r15.intValue());
    L40:
        String r16 = r10.c;
        if (r16 == null) goto L43;
        r6.putExtra("trigger_location", r16);
    L43:
        Boolean r17 = r10.f;
        if (r17 == null) goto L46;
        r6.putExtra("extra_is_at_vc", r17.booleanValue());
    L46:
        String r18 = r10.d;
        if (r18 == null) goto L49;
        r6.putExtra("extra_collection_id", r18);
    L49:
        Bundle r19 = r10.g;
        if (r19 == null) goto L52;
        r6.putExtras(r19);
    L52:
        if (r10 != null) goto L62;
    L56:
        if (r4 != null) goto L58;
        r8.startActivity(r6);     // Catch: Exception -> L54
        return;
    L58:
        r8.startActivityForResult(r6, r4.intValue());     // Catch: Exception -> L54
        return;
    L62:
        r4 = r10.e;     // Catch: Exception -> L54
    L54:
        e = move-exception;
        tt5.a.d("SelectorActivityNavigationManager", "startActivity fail: " + e);
    }
}
