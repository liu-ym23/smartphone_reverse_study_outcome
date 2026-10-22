package com.bytedance.android.livesdk.livecommerce.oldflash;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.livesdk.livecommerce.oldflash.search.LiveFlashBrandSearchRepository;
import com.bytedance.android.livesdk.livecommerce.oldflash.search.LiveFlashSearchDialogFragment;
import com.bytedance.android.livesdk.livecommerce.oldflash.select.LiveFlashMultiSelectDialogFragment;
import com.bytedance.android.livesdk.livecommerce.oldflash.select.LiveFlashSelectDialogFragment;
import com.bytedance.android.livesdk.livecommerce.utils.EComABUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class x<T> implements Observer {
    public final /* synthetic */ LiveFlashNewFragment a;

    public x(LiveFlashNewFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r15) {
        b r16 = (b) r15;
        if ((r16 instanceof f) == false) goto L10;
        f r17 = (f) r16;
        r17.b = !r17.b;
        LiveFlashNewFragment.ra0(this.a);
        LiveFlashViewModel r18 = (LiveFlashViewModel) this.a.g;
        if (r18 == null) goto L198;
        q r19 = r18.getEventHelper();
        if (r19 == null) goto L199;
        r19.b("more");
        return;
    L199:
        return;
    L198:
        return;
    L10:
        if ((r16 instanceof k) == false) goto L174;
        if ((r16 instanceof a) == false) goto L18;
        LiveFlashNewFragment r0 = this.a;
        int r2 = LiveFlashNewFragment.w;
        LiveFlashViewModel r1 = (LiveFlashViewModel) r0.g;
        if (r1 == null) goto L23;
        q r3 = r1.getEventHelper();
        if (r3 == null) goto L23;
        r3.c(((k) r16).b, "blank", ((a) r16).q);
    L23:
        final k r4 = (k) r16;
        FragmentActivity r5 = null;
        String r6 = "";
        if (r4.c == false) goto L80;
        LiveFlashNewFragment r110 = this.a;
        r110.getClass();
        si2.i r7 = s.s;
        Uri r8 = UriProtector.parse(EComABUtils.getFlashCategoryUrl());
        float r9 = r110.d.getHeight();
        Resources r10 = Resources.getSystem();
        String r11 = String.valueOf((int) (r9 / WindowDisplayMetricsOverride.apply(r10, r10.getDisplayMetrics()).density));
        if (r8 != null) goto L29;
    L42:
        String r12 = String.valueOf(r8);
        if (StringsKt.contains$default(r12, "anchor_id_placeholder", false, 2, null) == false) goto L52;
        LiveFlashViewModel r13 = (LiveFlashViewModel) r110.g;
        if (r13 == null) goto L50;
        String r14 = r13.getAnchorId();
        if (r14 == null) goto L50;
        String r20 = r14;
    L51:
        r12 = StringsKt.replace$default(r12, "anchor_id_placeholder", r20, false, 4, null);
    L50:
        r20 = "";
    L52:
        String r21 = r12;
        if (StringsKt.contains$default(r21, "categories_placeholder", false, 2, null) == false) goto L62;
        LiveFlashViewModel r22 = (LiveFlashViewModel) r110.g;
        if (r22 == null) goto L60;
        String r23 = r22.getCategoryIds();
        if (r23 == null) goto L60;
        String r24 = r23;
    L61:
        r21 = StringsKt.replace$default(r21, "categories_placeholder", r24, false, 4, null);
    L60:
        r24 = "";
    L62:
        String r25 = r21;
        if (StringsKt.contains$default(r25, "categories_name_placeholder", false, 2, null) == false) goto L72;
        LiveFlashViewModel r26 = (LiveFlashViewModel) r110.g;
        if (r26 == null) goto L70;
        String r27 = r26.getCategoryNames();
        if (r27 == null) goto L70;
        String r111 = r27;
    L71:
        r25 = StringsKt.replace$default(r25, "categories_name_placeholder", r111, false, 4, null);
    L70:
        r111 = "";
    L72:
        Context r112 = r110.getContext();
        if (r25 == null) goto L214;
        int r28 = ECSdk.a;
        IAdapterService r29 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r29 == null) goto L215;
        r29.handleSchemaWithLive(r112, UriProtector.parse(r25), false, new Bundle());
        return;
    L215:
        return;
    L214:
        return;
    L29:
        if (TextUtils.isEmpty(UriProtector.getQueryParameter(r8, "height")) == true) goto L42;
        Uri.Builder r30 = r8.buildUpon();
        r30.clearQuery();
        Iterator r31 = UriProtector.getQueryParameterNames(r8).iterator();
    L33:
        if (r31.hasNext() == false) goto L41;
        String r32 = (String) r31.next();
        if ((!Intrinsics.areEqual(r32, "height")) == true) goto L36;
        r30.appendQueryParameter(r32, r11);
        goto L33
    L36:
        Iterator r113 = UriProtector.getQueryParameters(r8, r32).iterator();
    L38:
        if (r113.hasNext() == false) goto L33;
        r30.appendQueryParameter(r32, (String) r113.next());
        goto L38
    L41:
        r8 = r30.build();
        goto L42
    L80:
        if (r4.d == false) goto L127;
        final LiveFlashNewFragment r114 = this.a;
        r114.getClass();
        int r33 = LiveFlashSearchDialogFragment.o;
        Context r34 = r114.getContext();
        if (r34 == null) goto L85;
        String r35 = th.a.g(r34, 2131896550);
        if (r35 == null) goto L85;
    L86:
        Context r36 = r114.getContext();
        if (r36 == null) goto L90;
        String r37 = th.a.g(r36, 2131896549);
        if (r37 == null) goto L90;
    L91:
        xi2.k0 r38 = r4.f;
        LiveFlashViewModel r39 = (LiveFlashViewModel) r114.g;
        if (r39 == null) goto L97;
        String r40 = r39.getCategoryId();
        if (r40 == null) goto L97;
        String r115 = r40;
    L98:
        LiveFlashViewModel r41 = (LiveFlashViewModel) r114.g;
        if (r41 == null) goto L104;
        String r42 = r41.getShopId();
        if (r42 == null) goto L104;
        String r116 = r42;
    L105:
        String r43 = r4.g;
        if (r43 != null) goto L108;
        String r117 = "";
    L109:
        String r44 = r4.m;
        if (r44 != null) goto L112;
        String r118 = "";
    L113:
        LiveFlashBrandSearchRepository r45 = new LiveFlashBrandSearchRepository(r38, r115, r116, r117, r118);
        Function1<String, Unit> r46 = new LiveFlashNewFragment$showQuery$fragment$1(r114, r4);
        Intrinsics.checkNotNullParameter(r35, "title");
        Intrinsics.checkNotNullParameter(r37, "searchHint");
        LiveFlashSearchDialogFragment r47 = new LiveFlashSearchDialogFragment();
        Bundle r48 = new Bundle();
        r48.putString("title_bar_title", r35);
        r48.putString("search_hint", r37);
        r47.setArguments(r48);
        r47.j = r45;
        r47.k = r46;
        FragmentActivity r119 = r114.getContext();
        if ((r119 instanceof FragmentActivity) == false) goto L117;
        r5 = r119;
    L117:
        FragmentActivity r49 = r5;
        if (r49 == null) goto L202;
        FragmentManager r120 = r49.getSupportFragmentManager();
        if (r120 == null) goto L203;
        LandscapeRestrictionOperation r50 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r47, "LiveFlashSearchDialogFragment", r50);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r120, r47, r50) == true) goto L216;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L182
    L125:
        r47.show(r120, "LiveFlashSearchDialogFragment");
        return;
    L216:
        return;
    L203:
        return;
    L202:
        return;
    L112:
        r118 = r44;
        goto L113
    L108:
        r117 = r43;
    L104:
        r116 = "";
    L97:
        r115 = "";
    L90:
        r37 = "";
    L85:
        r35 = "";
        goto L86
    L127:
        if (r4.p == false) goto L130;
        LiveFlashNewFragment.ka0(this.a, r16);
        return;
    L130:
        if (r4.e == false) goto L150;
        final LiveFlashNewFragment r121 = this.a;
        r121.getClass();
        int r51 = LiveFlashMultiSelectDialogFragment.n;
        Context r52 = r121.getContext();
        if (r52 == null) goto L137;
        String r53 = th.a.h(r52, 2131896604, new Object[]{r4.b});
        if (r53 == null) goto L137;
        r6 = r53;
    L137:
        com.bytedance.android.livesdk.livecommerce.oldflash.select.j r54 = new com.bytedance.android.livesdk.livecommerce.oldflash.select.j(r4.d(), r4.n);
        Function1<List<? extends String>, Unit> r55 = new LiveFlashNewFragment$showMultiSelect$fragment$1(r121, r4);
        Intrinsics.checkNotNullParameter(r6, "title");
        Intrinsics.checkNotNullParameter(r54, "multiSelectRepository");
        LiveFlashMultiSelectDialogFragment r56 = new LiveFlashMultiSelectDialogFragment();
        Bundle r57 = new Bundle();
        r57.putString("title_bar_title", r6);
        r56.setArguments(r57);
        r56.j = r54;
        r56.k = r55;
        FragmentActivity r122 = r121.getContext();
        if ((r122 instanceof FragmentActivity) == false) goto L141;
        r5 = r122;
    L141:
        FragmentActivity r58 = r5;
        if (r58 == null) goto L206;
        FragmentManager r123 = r58.getSupportFragmentManager();
        if (r123 == null) goto L207;
        LandscapeRestrictionOperation r59 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r56, "LiveFlashMultiSelectDialogFragment", r59);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r123, r56, r59) == true) goto L217;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L183
    L149:
        r56.show(r123, "LiveFlashMultiSelectDialogFragment");
        return;
    L217:
        return;
    L207:
        return;
    L206:
        return;
    L150:
        final LiveFlashNewFragment r124 = this.a;
        FragmentActivity r60 = r124.getContext();
        if (r60 == null) goto L209;
        LiveFlashSelectDialogFragment r61 = new LiveFlashSelectDialogFragment();
        String r62 = r4.b;
        List<String> r63 = r4.d();
        String r64 = r4.g;
        LiveFlashViewModel r65 = (LiveFlashViewModel) r124.g;
        if (r65 == null) goto L155;
        q r66 = r65.getEventHelper();
    L156:
        Function1<String, Unit> r67 = new LiveFlashNewFragment$showSelect$$inlined$let$lambda$1(r124, r4);
        Intrinsics.checkNotNullParameter(r60, "context");
        Intrinsics.checkNotNullParameter(r62, "property");
        Intrinsics.checkNotNullParameter(r63, "detailList");
        Intrinsics.checkNotNullParameter(r67, "callback");
        r61.m = r66;
        r61.j = r67;
        r61.l = r62;
        List<String> r68 = r63;
        ArrayList r125 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r68, 10));
        Iterator<T> r69 = r68.iterator();
    L158:
        if (r69.hasNext() == false) goto L160;
        String r70 = (String) r69.next();
        r125.add(new com.bytedance.android.livesdk.livecommerce.oldflash.select.b(r70, Intrinsics.areEqual(r70, r64)));
        goto L158
    L160:
        r61.k = r125;
        if ((r60 instanceof FragmentActivity) == false) goto L164;
        r5 = r60;
    L164:
        FragmentActivity r71 = r5;
        if (r71 == null) goto L210;
        FragmentManager r126 = r71.getSupportFragmentManager();
        if (r126 == null) goto L211;
        LandscapeRestrictionOperation r72 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r61, "LiveFlashSelectDialog", r72);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r126, r61, r72) == true) goto L218;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L184
    L172:
        r61.show(r126, "LiveFlashSelectDialog");
        return;
    L218:
        return;
    L211:
        return;
    L210:
        return;
    L155:
        r66 = null;
        goto L156
    L209:
        return;
    L18:
        LiveFlashNewFragment r73 = this.a;
        int r74 = LiveFlashNewFragment.w;
        LiveFlashViewModel r75 = (LiveFlashViewModel) r73.g;
        if (r75 == null) goto L23;
        q r76 = r75.getEventHelper();
        if (r76 == null) goto L23;
        r76.b(((k) r16).b);
        goto L23
    L174:
        if ((r16 instanceof l) == false) goto L213;
        LiveFlashNewFragment r77 = this.a;
        int r78 = LiveFlashNewFragment.w;
        LiveFlashViewModel r79 = (LiveFlashViewModel) r77.g;
        if (r79 == null) goto L180;
        q r80 = r79.getEventHelper();
        if (r80 == null) goto L180;
        r80.b(((l) r16).b);
    L180:
        LiveFlashNewFragment.ka0(this.a, r16);
        return;
    }
}
