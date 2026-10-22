package com.bytedance.ee.bear.office.common.upload;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class v extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageView f235433a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f235434b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f235435c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImageView f235436d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ImageView f235437e;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f235438a = null;

        static {
            int[] r100 = new int[OfficeUploadStatus.values().length];
            r100[OfficeUploadStatus.UPLOADING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[OfficeUploadStatus.FAILED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f235438a = r100;
        }
    }

    public v(Context r110) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110);
        ImageView r100 = new ImageView(r110);
        this.f235433a = r100;
        TextView r101 = new TextView(r110);
        r101.setTextColor(ContextCompat.getColor(r110, R.color.office_upload_text_primary));
        r101.setTextSize(17.0f);
        r101.setTypeface(Typeface.DEFAULT_BOLD);
        r101.setIncludeFontPadding(false);
        r101.setMaxLines(1);
        r101.setEllipsize(TextUtils.TruncateAt.END);
        this.f235434b = r101;
        TextView r102 = new TextView(r110);
        r102.setTextSize(14.0f);
        r102.setIncludeFontPadding(false);
        this.f235435c = r102;
        ImageView r103 = new ImageView(r110);
        r103.setImageResource(R.drawable.office_ic_upload_close);
        r103.setContentDescription(null);
        this.f235436d = r103;
        ImageView r104 = new ImageView(r110);
        r104.setImageResource(R.drawable.office_ic_upload_retry);
        r104.setContentDescription(null);
        this.f235437e = r104;
        setLayoutParams(new RecyclerView.LayoutParams(-1, e.a(r110, 80)));
        FrameLayout.LayoutParams r105 = new FrameLayout.LayoutParams(e.a(r110, 48), e.a(r110, 48));
        r105.gravity = 8388627;
        r105.leftMargin = e.a(r110, 20);
        Unit r106 = Unit.INSTANCE;
        addView(r100, r105);
        FrameLayout.LayoutParams r107 = new FrameLayout.LayoutParams(-1, -2);
        r107.gravity = 48;
        r107.leftMargin = e.a(r110, 84);
        r107.rightMargin = e.a(r110, 12);
        r107.topMargin = e.a(r110, 16);
        addView(r101, r107);
        FrameLayout.LayoutParams r108 = new FrameLayout.LayoutParams(-2, -2);
        r108.gravity = 8388659;
        r108.leftMargin = e.a(r110, 84);
        r108.topMargin = e.a(r110, 43);
        addView(r102, r108);
        FrameLayout.LayoutParams r109 = new FrameLayout.LayoutParams(e.a(r110, 20), e.a(r110, 20));
        r109.gravity = 8388629;
        r109.rightMargin = e.a(r110, 18);
        addView(r103, r109);
        FrameLayout.LayoutParams r111 = new FrameLayout.LayoutParams(e.a(r110, 20), e.a(r110, 20));
        r111.gravity = 8388629;
        r111.rightMargin = e.a(r110, 58);
        addView(r104, r111);
    }
}
