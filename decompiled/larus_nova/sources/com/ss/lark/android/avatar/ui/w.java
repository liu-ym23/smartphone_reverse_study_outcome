package com.ss.lark.android.avatar.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larksuite.component.universe_design.dialog.UDDialogBuilder;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.downloadlib.addownload.AdQuickAppManager;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f456776a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f456777a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f456778b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f456779c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f456777a == r101.f456777a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f456778b, r101.f456778b) == true) goto L15;
            return false;
        L15:
            if (this.f456779c == r101.f456779c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.f456777a * 31) + this.f456778b.hashCode()) * 31;
            if (this.f456779c == false) goto L5;
            int r101 = 1231;
        L7:
            return r100 + r101;
        L5:
            r101 = 1237;
            goto L7
        }

        public final String toString() {
            return "Param(iconId=" + this.f456777a + ", message=" + this.f456778b + ", isTurning=" + this.f456779c + ')';
        }

        public a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "message");
            this.f456777a = R.drawable.modify_avatar_loading;
            this.f456778b = r100;
            this.f456779c = true;
        }
    }

    public w(a r100) {
        Intrinsics.checkNotNullParameter(r100, "param");
        this.f456776a = r100;
    }

    public final UDDialog a(Context r110) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        View r100 = LayoutInflater.from(r110).inflate(R.layout.custom_popupwindow_layout, null);
        a r101 = this.f456776a;
        ImageView r102 = (ImageView) r100.findViewById(R.id.popup_icon_iv);
        TextView r103 = (TextView) r100.findViewById(R.id.popup_text_tv);
        if (r102 == null) goto L13;
        if (r103 == null) goto L13;
        r103.setText(r101.f456778b);
        int r104 = r101.f456777a;
        if (r104 != (-1)) goto L9;
        r102.setVisibility(8);
        goto L13
    L9:
        r102.setImageDrawable(UIUtils.getDrawable(r110, r104));
        r102.setVisibility(0);
        if (r101.f456779c == false) goto L13;
        RotateAnimation r105 = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        r105.setInterpolator(new LinearInterpolator());
        r105.setDuration(AdQuickAppManager.DEFAULT_QUICK_APP_CHECK_TIME);
        r105.setRepeatCount(-1);
        r105.setRepeatMode(1);
        r102.startAnimation(r105);
    L13:
        return new UDDialogBuilder(r110).rootLayout(r100).gravity(17).cancelOnTouchOutside(false).build();
    }
}
