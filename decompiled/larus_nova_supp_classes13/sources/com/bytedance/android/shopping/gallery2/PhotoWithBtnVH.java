package com.bytedance.android.shopping.gallery2;

import android.app.Activity;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.btm.c;
import com.bytedance.android.ec.core.opt.ab.p;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ec.sdk.helper.h;
import com.bytedance.android.shopping.anchorv4.data.AnchorV4DataManager;
import com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.j;
import com.bytedance.android.shopping.extensions.ViewExtensionsKt;
import com.bytedance.mt.protector.impl.UriProtector;
import jj4.b;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/gallery2/PhotoWithBtnVH;", "Lcom/bytedance/android/shopping/gallery2/PhotoVH;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class PhotoWithBtnVH extends PhotoVH {
    public final LinearLayout d;
    public String e;
    public boolean f;
    public final j g;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ PhotoWithBtnVH a;
        public final /* synthetic */ View b;

        /* JADX INFO: renamed from: com.bytedance.android.shopping.gallery2.PhotoWithBtnVH$a$a, reason: collision with other inner class name */
        public static final class C0072a implements ri.a {
            public C0072a() {
            }
        }

        public a(PhotoWithBtnVH r1, View r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r7) {
            String r8 = BtmSDK.createJumpSourceBtmToken$default(BtmSDK.INSTANCE, "a1.b8094.c86220.d94403", PageFinder.via(this.b), null, 4, null);
            Lazy r0 = ECSettingKeys.a;
            int r1 = p.a;
            Object r2 = Boolean.FALSE;
            Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L7
            b r4 = b.b;     // Catch: Throwable -> L7
            Object r5 = jj4.a.a("ec_fix_pdp_gallery_old_find_same_jump", Boolean.class, r2, false);     // Catch: Throwable -> L7
            if (r5 != null) goto L14;
            Intrinsics.throwNpe();     // Catch: Throwable -> L7
        L14:
            if (((Boolean) r5).booleanValue() == false) goto L21;
            Activity r6 = ECAppInfoService.e.getCurrentActivity();
            if (r6 == null) goto L30;
            String r9 = this.a.e;
            if (r9 == null) goto L31;
            Uri.Builder r10 = UriProtector.parse(r9).buildUpon();
            r10.appendQueryParameter("identifier", AnchorV4DataManager.d);
            com.bytedance.android.ec.sdk.helper.p.a.d(c.d(r10.build().toString(), r8), r6);
            return;
        L31:
            return;
        L30:
            return;
        L21:
            Activity r11 = ECAppInfoService.e.getCurrentActivity();
            if (r11 == null) goto L32;
            h r12 = h.a;
            String r13 = this.a.c;
            if (r13 != null) goto L26;
            r13 = "";
        L26:
            r12.a(r11, r13, new C0072a());
            return;
        L32:
            return;
        L7:
            th = move-exception;
            Result.Companion r14 = Result.Companion;
            Object r15 = Result.constructor-impl(ResultKt.createFailure(th));
            if (Result.isFailure-impl(r15) == true) goto L12;
            r2 = r15;
        L12:
            r5 = r2;
            goto L14
        }
    }

    public int T3() {
        return 1;
    }

    public final void U3(String r6) {
        if (this.f == false) goto L5;
        return;
    L5:
        this.e = r6;
        LinearLayout r0 = this.d;
        boolean r1 = true;
        if (r6 != null) goto L8;
    L11:
        boolean r7 = true;
    L12:
        wg.a.h(r0, !r7);
        if (this.d.getVisibility() == 0) goto L16;
        r1 = false;
    L16:
        if (r1 == true) goto L18;
        return;
    L18:
        if (ECSettingKeys.o0() != 2) goto L25;
        LinearLayout r8 = this.d;
        r8.setBackgroundResource(2131233381);
        int r2 = com.bytedance.android.shopping.extensions.b.a(Double.valueOf(16.5d));
        r8.setPadding(r2, 0, r2, 0);
        ImageView r9 = (ImageView) this.d.findViewById(2131376580);
        r9.setVisibility(0);
        r9.setImageResource(2131248157);
        TextView r10 = (TextView) this.d.findViewById(2131390630);
        r10.setText(th.a.g(r10.getContext(), 2131913984));
        ViewExtensionsKt.h(r10, 15);
        r10.setIncludeFontPadding(false);
        ImageView r11 = (ImageView) this.d.findViewById(2131376558);
        r11.setImageResource(2131248156);
        ViewGroup.LayoutParams r3 = r11.getLayoutParams();
        if ((r3 instanceof ViewGroup.MarginLayoutParams) == true) goto L22;
        r3 = null;
    L22:
        ViewGroup.MarginLayoutParams r4 = (ViewGroup.MarginLayoutParams) r3;
        if (r4 == null) goto L25;
        r4.width = com.bytedance.android.shopping.extensions.b.a(16);
        r4.height = com.bytedance.android.shopping.extensions.b.a(16);
        r4.leftMargin = 0;
        r11.setLayoutParams(r4);
    L25:
        j r12 = this.g;
        if (r12 == null) goto L30;
        r12.a(T3(), null, null);
        return;
    L30:
        return;
    L8:
        if (r6.length() == 0) goto L11;
        r7 = false;
        goto L12
    }

    public PhotoWithBtnVH(View r2, j r3) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        super(r2);
        this.g = r3;
        LinearLayout r4 = (LinearLayout) r2.findViewById(2131370773);
        this.d = r4;
        r4.setOnClickListener(new a(this, r2));
    }
}
