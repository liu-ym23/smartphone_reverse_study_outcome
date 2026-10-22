package com.ss.android.lark.officesdk.minutes.ui.record.recording.subtitle.ui;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f436491a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f436492b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f436493c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImageView f436494d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View f436495e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final View f436496f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final View f436497g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final PopupWindow f436498h;

    public static final class a {
    }

    static {
    }

    public c(Context r100, MmSubtitleFragment.b r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "listener");
        this.f436491a = r100;
        this.f436492b = r101;
        View r102 = LayoutInflater.from(r100).inflate(R.layout.office_sdk_mm_layout_subtitle_action_menu, null);
        this.f436497g = r102.findViewById(R.id.subtitle_action_menu_body);
        this.f436495e = r102.findViewById(R.id.action_mark);
        View r103 = r102.findViewById(R.id.action_copy);
        this.f436496f = r103;
        this.f436494d = (ImageView) r102.findViewById(R.id.iv_mark);
        this.f436493c = (TextView) r102.findViewById(R.id.tv_mark);
        ((TextView) r102.findViewById(R.id.tv_copy)).setText(R.string.View_Common_Copy_Button);
        r103.setOnClickListener(new com.ss.android.lark.officesdk.minutes.ui.record.recording.subtitle.ui.a(this));
        PopupWindow r104 = new PopupWindow(r102, -2, -2, true);
        r104.setBackgroundDrawable(new ColorDrawable(0));
        r104.setOutsideTouchable(true);
        r104.setOnDismissListener(new b(this));
        this.f436498h = r104;
    }
}
