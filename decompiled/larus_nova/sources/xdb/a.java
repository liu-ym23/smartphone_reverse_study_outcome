package xdb;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.larus.nova.R;
import com.ss.android.lark.feed.cardcomponent.titleright.TitleRightView;
import com.ss.android.lark.feed.export.feedcard.FeedCardComponent;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class a extends FeedCardComponent<b, TitleRightView> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f563304c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f563305d;

    /* JADX INFO: renamed from: xdb.a$a, reason: collision with other inner class name */
    public static final class C8219a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f563306a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Drawable f563307b;

        public b(String r100, Drawable r101, int r102) {
            if ((r102 & 1) == 0) goto L6;
            r100 = null;
        L6:
            if ((r102 & 2) == 0) goto L8;
            r101 = null;
        L8:
            this.f563306a = r100;
            this.f563307b = r101;
        }
    }

    static {
    }

    @Override // com.ss.android.lark.feed.export.feedcard.FeedCardComponent
    public final View a() {
        return new TitleRightView(getContext());
    }

    public a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f563304c = R.color.flow_feed_time_text;
        this.f563305d = 12;
    }

    public final void d(b r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        TitleRightView r101 = c();
        String r102 = r100.f563306a;
        Drawable r103 = r100.f563307b;
        TextView r104 = null;
        if (r103 == null) goto L15;
        AppCompatImageView r105 = r101.f420991b;
        if (r105 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("flagView");
        r105 = null;
    L7:
        r105.setImageDrawable(r103);
        AppCompatImageView r106 = r101.f420991b;
        if (r106 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("flagView");
        r106 = null;
    L10:
        r106.setVisibility(0);
        TextView r107 = r101.f420990a;
        if (r107 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("textView");
    L14:
        r104.setVisibility(8);
    L38:
        c().setTextViewColorRes(this.f563304c);
        c().setTextViewTextSize(this.f563305d);
        return;
    L13:
        r104 = r107;
        goto L14
    L15:
        AppCompatImageView r108 = r101.f420991b;
        if (r108 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("flagView");
        r108 = null;
    L18:
        r108.setVisibility(8);
        TextView r109 = r101.f420990a;
        if (r109 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("textView");
        r109 = null;
    L21:
        r109.setVisibility(0);
        TextView r110 = r101.f420990a;
        if (r110 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("textView");
        r110 = null;
    L24:
        r110.setText(null);
        if (r102 == null) goto L33;
        TextView r111 = r101.f420990a;
        if (r111 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("textView");
        r111 = null;
    L29:
        r111.setText(r102);
        TextView r112 = r101.f420990a;
        if (r112 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("textView");
        r112 = null;
    L32:
        r112.setBackground(null);
        goto L38
    L33:
        TextView r113 = r101.f420990a;
        if (r113 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("textView");
    L37:
        r104.setVisibility(8);
        goto L38
    L36:
        r104 = r113;
        goto L37
    }
}
