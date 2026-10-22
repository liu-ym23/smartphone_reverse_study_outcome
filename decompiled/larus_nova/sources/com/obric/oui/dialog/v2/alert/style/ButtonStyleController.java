package com.obric.oui.dialog.v2.alert.style;

import com.obric.oui.button.OButton;
import com.obric.oui.dialog.base.AbstractDialog;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.Intrinsics;
import zla.h;

/* JADX INFO: loaded from: classes34.dex */
public abstract class ButtonStyleController implements h {

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/obric/oui/dialog/v2/alert/style/ButtonStyleController$ButtonStyle;", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface ButtonStyle {
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/dialog/v2/alert/style/ButtonStyleController$TextColorType;", "", "TextReverse", "TextReverse2", "Negative", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
    @Deprecated(message = "待废弃")
    public static final enum TextColorType extends Enum<TextColorType> {
        public static final TextColorType Negative = null;
        public static final TextColorType TextReverse = null;
        public static final TextColorType TextReverse2 = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ TextColorType[] f400763a = null;

        public static TextColorType valueOf(String r100) {
            return (TextColorType) r27.a.a(TextColorType.class, r100);
        }

        public static TextColorType[] values() {
            return (TextColorType[]) f400763a.clone();
        }

        static {
            TextColorType r100 = new TextColorType("TextReverse", 0);
            TextReverse = r100;
            TextColorType r101 = new TextColorType("TextReverse2", 1);
            TextReverse2 = r101;
            TextColorType r102 = new TextColorType("Negative", 2);
            Negative = r102;
            f400763a = new TextColorType[]{r100, r101, r102};
        }

        public TextColorType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    static {
    }

    public ButtonStyleController() {
    }

    public abstract OButton d();

    public abstract OButton e();

    public abstract OButton f();

    @Override // zla.h
    public void b(AbstractDialog r100) {
        Intrinsics.checkNotNullParameter(this, "this");
        Intrinsics.checkNotNullParameter(r100, "dialog");
    }

    @Override // zla.h
    public void c(zla.a r100) {
        h.a.a(this, r100);
    }
}
