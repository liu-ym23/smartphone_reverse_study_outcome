package com.larus.account.base.model;

import com.byted.mgl.merge.service.api.ui.BdpGameHostBaseUIService;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0011B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0012"}, d2 = {"Lcom/larus/account/base/model/NeutralAgeGateStyle;", "", "style", "", "mobType", "", "<init>", "(Ljava/lang/String;IILjava/lang/String;)V", "getStyle", "()I", "getMobType", "()Ljava/lang/String;", "DIALOG", "ROLLER", "INPUT", "CLICK_STEP", "YEAR", "Companion", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum NeutralAgeGateStyle extends Enum<NeutralAgeGateStyle> {
    public static final NeutralAgeGateStyle CLICK_STEP = null;
    public static final a Companion = null;
    public static final NeutralAgeGateStyle DIALOG = null;
    public static final NeutralAgeGateStyle INPUT = null;
    public static final NeutralAgeGateStyle ROLLER = null;
    public static final NeutralAgeGateStyle YEAR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ NeutralAgeGateStyle[] f286203a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f286204b = null;
    private final String mobType;
    private final int style;

    public static final class a {
        public a() {
        }

        public static String a(int r100) {
            NeutralAgeGateStyle[] r101 = NeutralAgeGateStyle.values();
            int r102 = r101.length;
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L11;
            NeutralAgeGateStyle r104 = r101[r103];
            if (r104.getStyle() != r100) goto L7;
            boolean r105 = true;
        L8:
            if (r105 == true) goto L12;
            r103 = r103 + 1;
        L12:
            if (r104 == null) goto L15;
            String r106 = r104.getMobType();
            if (r106 == null) goto L15;
            return r106;
        L15:
            return "";
        L7:
            r105 = false;
            goto L8
        L11:
            r104 = null;
            goto L12
        }
    }

    public static EnumEntries<NeutralAgeGateStyle> getEntries() {
        return f286204b;
    }

    static {
        NeutralAgeGateStyle r100 = new NeutralAgeGateStyle("DIALOG", 0, 1, "dialog");
        DIALOG = r100;
        NeutralAgeGateStyle r101 = new NeutralAgeGateStyle("ROLLER", 1, 2, "roller");
        ROLLER = r101;
        NeutralAgeGateStyle r102 = new NeutralAgeGateStyle("INPUT", 2, 3, "input");
        INPUT = r102;
        NeutralAgeGateStyle r103 = new NeutralAgeGateStyle("CLICK_STEP", 3, 4, "click");
        CLICK_STEP = r103;
        NeutralAgeGateStyle r104 = new NeutralAgeGateStyle("YEAR", 4, 5, BdpGameHostBaseUIService.DATE_PICKER_TYPE_YEAR);
        YEAR = r104;
        NeutralAgeGateStyle[] r110 = {r100, r101, r102, r103, r104};
        f286203a = r110;
        f286204b = EnumEntriesKt.enumEntries(r110);
        Companion = new a();
    }

    public static NeutralAgeGateStyle[] values() {
        return (NeutralAgeGateStyle[]) f286203a.clone();
    }

    public final String getMobType() {
        return this.mobType;
    }

    public final int getStyle() {
        return this.style;
    }

    public static NeutralAgeGateStyle valueOf(String r100) {
        return (NeutralAgeGateStyle) r27.a.a(NeutralAgeGateStyle.class, r100);
    }

    public NeutralAgeGateStyle(String r100, int r101, int r102, String r103) {
        super(r100, r101);
        this.style = r102;
        this.mobType = r103;
    }
}
