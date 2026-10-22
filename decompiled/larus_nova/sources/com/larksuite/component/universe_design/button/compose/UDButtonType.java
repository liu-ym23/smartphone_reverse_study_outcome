package com.larksuite.component.universe_design.button.compose;

import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u001d\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001Be\b\u0002\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0004\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0013\u0010\u0011R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0014\u0010\u0011R\u0018\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0015\u0010\u0011R\u0018\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0016\u0010\u0011R\u0018\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0017\u0010\u0011j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001f¨\u0006 "}, d2 = {"Lcom/larksuite/component/universe_design/button/compose/UDButtonType;", "", "backgroundColorRes", "", "textColorRes", "strokeColorRes", "disabledTextColorRes", "loadingBackgroundColorRes", "loadingTextColorRes", "loadingStrokeColorRes", "loadingIndicatorColorRes", "<init>", "(Ljava/lang/String;IIILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getBackgroundColorRes$universe_ui_button_release", "()I", "getTextColorRes$universe_ui_button_release", "getStrokeColorRes$universe_ui_button_release", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getDisabledTextColorRes$universe_ui_button_release", "getLoadingBackgroundColorRes$universe_ui_button_release", "getLoadingTextColorRes$universe_ui_button_release", "getLoadingStrokeColorRes$universe_ui_button_release", "getLoadingIndicatorColorRes$universe_ui_button_release", "Primary", "SecondaryGray", "SecondaryBlue", "SecondaryRed", "Danger", "TextPrimary", "TextSecondary", "TextDanger", "universe-ui-button_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum UDButtonType extends Enum<UDButtonType> {
    public static final UDButtonType Danger = null;
    public static final UDButtonType Primary = null;
    public static final UDButtonType SecondaryBlue = null;
    public static final UDButtonType SecondaryGray = null;
    public static final UDButtonType SecondaryRed = null;
    public static final UDButtonType TextDanger = null;
    public static final UDButtonType TextPrimary = null;
    public static final UDButtonType TextSecondary = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ UDButtonType[] f284609a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f284610b = null;
    private final int backgroundColorRes;
    private final Integer disabledTextColorRes;
    private final Integer loadingBackgroundColorRes;
    private final Integer loadingIndicatorColorRes;
    private final Integer loadingStrokeColorRes;
    private final Integer loadingTextColorRes;
    private final Integer strokeColorRes;
    private final int textColorRes;

    public UDButtonType() {
        throw null;
    }

    public static EnumEntries<UDButtonType> getEntries() {
        return f284610b;
    }

    static {
        Integer r210 = Integer.valueOf(R.color.udtoken_btn_pri_text_disabled);
        Integer r100 = Integer.valueOf(R.color.primary_fill_loading);
        Integer r211 = Integer.valueOf(R.color.static_white);
        UDButtonType r110 = new UDButtonType("Primary", 0, R.color.ud_button_blue_bg, R.color.static_white, null, r210, r100, null, null, r211, 100, null);
        Primary = r110;
        Integer r310 = Integer.valueOf(R.color.line_border_component);
        Integer r311 = Integer.valueOf(R.color.udtoken_component_text_disabled_loading);
        Integer r312 = Integer.valueOf(R.color.ud_N400);
        Integer r101 = Integer.valueOf(R.color.primary_content_default);
        UDButtonType r102 = new UDButtonType("SecondaryGray", 1, R.color.ud_button_white_grey_bg, R.color.ud_button_grey_text, r310, null, null, r311, r312, r101, 24, null);
        SecondaryGray = r102;
        UDButtonType r103 = new UDButtonType("SecondaryBlue", 2, R.color.ud_button_white_blue_bg, R.color.ud_button_blue_text, Integer.valueOf(R.color.ud_button_blue_stroke), null, null, null, Integer.valueOf(R.color.primary_content_loading), r101, 56, null);
        SecondaryBlue = r103;
        Integer r510 = Integer.valueOf(R.color.ud_button_red_stroke);
        Integer r511 = Integer.valueOf(R.color.function_danger_content_loading);
        Integer r104 = Integer.valueOf(R.color.function_danger_content_default);
        UDButtonType r105 = new UDButtonType("SecondaryRed", 3, R.color.ud_button_white_red_bg, R.color.ud_button_red_text, r510, null, null, null, r511, r104, 56, null);
        SecondaryRed = r105;
        UDButtonType r106 = new UDButtonType("Danger", 4, R.color.ud_button_red_bg, R.color.static_white, null, r210, Integer.valueOf(R.color.function_danger_fill_loading), null, null, r211, 100, null);
        Danger = r106;
        UDButtonType r107 = new UDButtonType("TextPrimary", 5, R.color.ud_button_text_primary_bg, R.color.ud_button_blue_text, null, null, null, null, null, r101, 124, null);
        TextPrimary = r107;
        UDButtonType r108 = new UDButtonType("TextSecondary", 6, R.color.ud_button_text_secondary_bg, R.color.ud_button_grey_text, null, null, null, null, null, Integer.valueOf(R.color.text_title), 124, null);
        TextSecondary = r108;
        UDButtonType r109 = new UDButtonType("TextDanger", 7, R.color.ud_button_text_error_bg, R.color.ud_button_red_text, null, null, null, null, null, r104, 124, null);
        TextDanger = r109;
        UDButtonType[] r111 = {r110, r102, r103, r105, r106, r107, r108, r109};
        f284609a = r111;
        f284610b = EnumEntriesKt.enumEntries(r111);
    }

    public static UDButtonType[] values() {
        return (UDButtonType[]) f284609a.clone();
    }

    public final int getBackgroundColorRes$universe_ui_button_release() {
        return this.backgroundColorRes;
    }

    public final Integer getDisabledTextColorRes$universe_ui_button_release() {
        return this.disabledTextColorRes;
    }

    public final Integer getLoadingBackgroundColorRes$universe_ui_button_release() {
        return this.loadingBackgroundColorRes;
    }

    public final Integer getLoadingIndicatorColorRes$universe_ui_button_release() {
        return this.loadingIndicatorColorRes;
    }

    public final Integer getLoadingStrokeColorRes$universe_ui_button_release() {
        return this.loadingStrokeColorRes;
    }

    public final Integer getLoadingTextColorRes$universe_ui_button_release() {
        return this.loadingTextColorRes;
    }

    public final Integer getStrokeColorRes$universe_ui_button_release() {
        return this.strokeColorRes;
    }

    public final int getTextColorRes$universe_ui_button_release() {
        return this.textColorRes;
    }

    public static UDButtonType valueOf(String r100) {
        return (UDButtonType) r27.a.a(UDButtonType.class, r100);
    }

    public UDButtonType(String r100, int r101, int r102, int r103, Integer r104, Integer r105, Integer r106, Integer r107, Integer r110, Integer r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 4) == 0) goto L6;
        r104 = null;
    L6:
        if ((r112 & 8) == 0) goto L9;
        r105 = null;
    L9:
        if ((r112 & 16) == 0) goto L12;
        r106 = null;
    L12:
        if ((r112 & 32) == 0) goto L15;
        r107 = null;
    L15:
        if ((r112 & 64) == 0) goto L18;
        r110 = null;
    L18:
        if ((r112 & 128) == 0) goto L20;
        r111 = null;
    L20:
        super(r100, r101);
        this.backgroundColorRes = r102;
        this.textColorRes = r103;
        this.strokeColorRes = r104;
        this.disabledTextColorRes = r105;
        this.loadingBackgroundColorRes = r106;
        this.loadingTextColorRes = r107;
        this.loadingStrokeColorRes = r110;
        this.loadingIndicatorColorRes = r111;
    }
}
