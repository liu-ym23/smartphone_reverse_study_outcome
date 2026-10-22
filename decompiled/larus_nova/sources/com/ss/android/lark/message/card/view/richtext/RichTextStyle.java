package com.ss.android.lark.message.card.view.richtext;

/* JADX INFO: loaded from: classes36.dex */
public final class RichTextStyle {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f431972a = null;

    public static final enum ButtonMode extends Enum<ButtonMode> {
        public static final ButtonMode MODE_DANGER = null;
        public static final ButtonMode MODE_DEFAULT = null;
        public static final ButtonMode MODE_PRIMARY = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ButtonMode[] f431973a = null;
        private String mode;

        static {
            ButtonMode r100 = new ButtonMode("MODE_DEFAULT", 0, "default");
            MODE_DEFAULT = r100;
            ButtonMode r101 = new ButtonMode("MODE_PRIMARY", 1, "primary");
            MODE_PRIMARY = r101;
            ButtonMode r102 = new ButtonMode("MODE_DANGER", 2, "danger");
            MODE_DANGER = r102;
            f431973a = new ButtonMode[]{r100, r101, r102};
        }

        public static ButtonMode[] values() {
            return (ButtonMode[]) f431973a.clone();
        }

        public String getMode() {
            return this.mode;
        }

        public static ButtonMode valueOf(String r100) {
            return (ButtonMode) r27.a.a(ButtonMode.class, r100);
        }

        public ButtonMode(String r100, int r101, String r102) {
            super(r100, r101);
            this.mode = r102;
        }
    }

    static {
        f431972a = new String[]{"backgroundColor", "backgroundColorDisable", "backgroundColorActive", "borderWidth", "borderColor", "borderRadius", "backgroundColorToken", "backgroundColorDisableToken", "backgroundColorActiveToken", "borderColorToken"};
    }
}
