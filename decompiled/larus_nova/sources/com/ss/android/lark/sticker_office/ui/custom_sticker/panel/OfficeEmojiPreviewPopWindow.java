package com.ss.android.lark.sticker_office.ui.custom_sticker.panel;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBindings;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.ss.android.lark.sticker_office.databinding.PopupStickerPreviewBinding;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class OfficeEmojiPreviewPopWindow extends PopupWindow {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f440890a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PopupStickerPreviewBinding f440891b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c f440892c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View.OnClickListener f440893d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f440894e;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/sticker_office/ui/custom_sticker/panel/OfficeEmojiPreviewPopWindow$Position;", "", "<init>", "(Ljava/lang/String;I)V", "LEFT", "CENTER", "RIGHT", "sticker-office_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Position extends Enum<Position> {
        public static final Position CENTER = null;
        public static final Position LEFT = null;
        public static final Position RIGHT = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Position[] f440895a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f440896b = null;

        public static EnumEntries<Position> getEntries() {
            return f440896b;
        }

        static {
            Position r100 = new Position("LEFT", 0);
            LEFT = r100;
            Position r101 = new Position("CENTER", 1);
            CENTER = r101;
            Position r102 = new Position("RIGHT", 2);
            RIGHT = r102;
            Position[] r103 = {r100, r101, r102};
            f440895a = r103;
            f440896b = EnumEntriesKt.enumEntries(r103);
        }

        public static Position[] values() {
            return (Position[]) f440895a.clone();
        }

        public static Position valueOf(String r100) {
            return (Position) r27.a.a(Position.class, r100);
        }

        public Position(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OfficeEmojiPreviewPopWindow f440897a;

        public a(OfficeEmojiPreviewPopWindow r100) {
            this.f440897a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            OfficeEmojiPreviewPopWindow r101 = this.f440897a;
            if (r101.f440894e == true) goto L6;
            r101.f440894e = true;
            r101.f440891b.f440857b.setSelected(true);
            return;
        L6:
            View.OnClickListener r102 = r101.f440893d;
            if (r102 == null) goto L9;
            r102.onClick(r100);
        L9:
            OfficeEmojiPreviewPopWindow r103 = this.f440897a;
            PopupWindowLancet.handleDismissBeforeOrigin(r103);
            r103.dismiss();
        }
    }

    public static final class b {
    }

    public interface c {
        void a(Context r100, int r101, int r102, String r103, AppCompatImageView r104, String r105);
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f440898a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f440899b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f440900c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f440901d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f440902e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Position f440903f;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L8;
            return false;
        L8:
            d r101 = (d) r100;
            if (Intrinsics.areEqual(this.f440898a, r101.f440898a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f440899b, r101.f440899b) == true) goto L15;
            return false;
        L15:
            if (this.f440900c == r101.f440900c) goto L18;
            return false;
        L18:
            if (this.f440901d == r101.f440901d) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f440902e, r101.f440902e) == true) goto L24;
            return false;
        L24:
            if (this.f440903f == r101.f440903f) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            int r100 = ((((((this.f440898a.hashCode() * 31) + this.f440899b.hashCode()) * 31) + this.f440900c) * 31) + this.f440901d) * 31;
            String r101 = this.f440902e;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return ((r100 + r102) * 31) + this.f440903f.hashCode();
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public final String toString() {
            return "Params(anchorView=" + this.f440898a + ", key=" + this.f440899b + ", width=" + this.f440900c + ", height=" + this.f440901d + ", path=" + this.f440902e + ", position=" + this.f440903f + ')';
        }

        public d(View r100, String r101, int r102, int r103, String r104, Position r105) {
            Intrinsics.checkNotNullParameter(r100, "anchorView");
            Intrinsics.checkNotNullParameter(r101, "key");
            Intrinsics.checkNotNullParameter(r105, "position");
            this.f440898a = r100;
            this.f440899b = r101;
            this.f440900c = r102;
            this.f440901d = r103;
            this.f440902e = r104;
            this.f440903f = r105;
        }
    }

    static {
    }

    public OfficeEmojiPreviewPopWindow(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f440890a = r100;
        View r101 = LayoutInflater.from(r100).inflate(R.layout.popup_sticker_preview, null, false);
        int r102 = R.id.btnRemove;
        TextView r103 = (TextView) ViewBindings.findChildViewById(r101, R.id.btnRemove);
        if (r103 == null) goto L11;
        r102 = R.id.ivPreview;
        AppCompatImageView r104 = (AppCompatImageView) ViewBindings.findChildViewById(r101, R.id.ivPreview);
        if (r104 == null) goto L11;
        r102 = R.id.llPreviewBg;
        LinearLayout r105 = (LinearLayout) ViewBindings.findChildViewById(r101, R.id.llPreviewBg);
        if (r105 == null) goto L11;
        FrameLayout r106 = (FrameLayout) r101;
        this.f440891b = new PopupStickerPreviewBinding(r106, r103, r104, r105);
        setContentView(r106);
        setWidth(-2);
        setHeight(-2);
        r106.setFocusable(true);
        r106.setFocusableInTouchMode(true);
        r103.setOnClickListener(new a(this));
        setInputMethodMode(1);
        setFocusable(true);
        setOutsideTouchable(true);
        setBackgroundDrawable(new ColorDrawable(0));
        return;
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r101.getResources().getResourceName(r102)));
    }
}
