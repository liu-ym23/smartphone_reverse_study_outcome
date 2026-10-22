package com.edu.onetex.latex;

import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0017\b\u0017\u0018\u00002\u00020\u0001Ba\u0012\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0007¢\u0006\u0002\u0010\fR&\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R&\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010R\u0011\u0010\u000b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\t\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0014\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\n\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0017R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0014\"\u0004\b\u001b\u0010\u0017R\u001a\u0010\b\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0014\"\u0004\b\u001d\u0010\u0017¨\u0006\u001e"}, d2 = {"Lcom/edu/onetex/latex/OneTexConfiguration;", "", "commandReplacementMapping", "", "", "commandRollbackMapping", "supportNewCommand", "", "supportNewCommandV2", "fontBold", "lowVersionCompat", "fixAlignLeft", "(Ljava/util/Map;Ljava/util/Map;ZZZZZ)V", "getCommandReplacementMapping", "()Ljava/util/Map;", "setCommandReplacementMapping", "(Ljava/util/Map;)V", "getCommandRollbackMapping", "setCommandRollbackMapping", "getFixAlignLeft", "()Z", "getFontBold", "setFontBold", "(Z)V", "getLowVersionCompat", "setLowVersionCompat", "getSupportNewCommand", "setSupportNewCommand", "getSupportNewCommandV2", "setSupportNewCommandV2", "onetex_release"}, k = 1, mv = {1, 4, 2})
public class OneTexConfiguration {
    private Map<String, String> commandReplacementMapping;
    private Map<String, String> commandRollbackMapping;
    private final boolean fixAlignLeft;
    private boolean fontBold;
    private boolean lowVersionCompat;
    private boolean supportNewCommand;
    private boolean supportNewCommandV2;

    public final Map<String, String> getCommandReplacementMapping() {
        return this.commandReplacementMapping;
    }

    public final Map<String, String> getCommandRollbackMapping() {
        return this.commandRollbackMapping;
    }

    public final boolean getFixAlignLeft() {
        return this.fixAlignLeft;
    }

    public final boolean getFontBold() {
        return this.fontBold;
    }

    public final boolean getLowVersionCompat() {
        return this.lowVersionCompat;
    }

    public final boolean getSupportNewCommand() {
        return this.supportNewCommand;
    }

    public final boolean getSupportNewCommandV2() {
        return this.supportNewCommandV2;
    }

    public final void setCommandReplacementMapping(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.commandReplacementMapping = r100;
    }

    public final void setCommandRollbackMapping(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.commandRollbackMapping = r100;
    }

    public final void setFontBold(boolean r100) {
        this.fontBold = r100;
    }

    public final void setLowVersionCompat(boolean r100) {
        this.lowVersionCompat = r100;
    }

    public final void setSupportNewCommand(boolean r100) {
        this.supportNewCommand = r100;
    }

    public final void setSupportNewCommandV2(boolean r100) {
        this.supportNewCommandV2 = r100;
    }

    public OneTexConfiguration(Map<String, String> r100, Map<String, String> r101, boolean r102, boolean r103, boolean r104, boolean r105, boolean r106) {
        Intrinsics.checkNotNullParameter(r100, "commandReplacementMapping");
        Intrinsics.checkNotNullParameter(r101, "commandRollbackMapping");
        this.commandReplacementMapping = r100;
        this.commandRollbackMapping = r101;
        this.supportNewCommand = r102;
        this.supportNewCommandV2 = r103;
        this.fontBold = r104;
        this.lowVersionCompat = r105;
        this.fixAlignLeft = r106;
    }

    public /* synthetic */ OneTexConfiguration(Map r110, Map r111, boolean r112, boolean r113, boolean r114, boolean r115, boolean r116, int r117, DefaultConstructorMarker r118) {
        if ((r117 & 1) == 0) goto L5;
        Map r100 = MapsKt.emptyMap();
    L7:
        if ((r117 & 2) == 0) goto L9;
        Map r101 = MapsKt.emptyMap();
    L11:
        if ((r117 & 8) == 0) goto L13;
        boolean r102 = false;
    L15:
        if ((r117 & 16) == 0) goto L17;
        boolean r103 = false;
    L19:
        if ((r117 & 32) == 0) goto L21;
        boolean r104 = false;
    L23:
        if ((r117 & 64) == 0) goto L25;
        boolean r105 = false;
    L26:
        this(r100, r101, r112, r102, r103, r104, r105);
        return;
    L25:
        r105 = r116;
        goto L26
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }
}
