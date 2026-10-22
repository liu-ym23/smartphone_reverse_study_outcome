package com.larus.avlink.simulInterpret.page.model;

import com.larus.dora.api.DoraConfig;
import ea8.w;
import ha8.d;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B[\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\bHÆ\u0003J\u000f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0003J\u000f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001aJb\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010$J\u0013\u0010%\u001a\u00020\b2\b\u0010&\u001a\u0004\u0018\u00010'HÖ\u0003J\t\u0010(\u001a\u00020)HÖ\u0001J\t\u0010*\u001a\u00020+HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0015R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0015\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001a¨\u0006,"}, d2 = {"Lcom/larus/avlink/simulInterpret/page/model/SimultaneousInterpretState;", "Lcom/larus/ui/arch/vm/external/ComponentState;", "screenMode", "Lcom/larus/avlink/simulInterpret/page/model/ScreenMode;", "topTranslateLanguage", "Lcom/larus/avlink/simulInterpret/page/model/Language;", "bottomTranslateLanguage", "isSiMute", "", "topTranslationResultList", "", "Lcom/larus/avlink/simulInterpret/page/model/TranslationResultItem;", "bottomTranslationResultList", "needRotated", "<init>", "(Lcom/larus/avlink/simulInterpret/page/model/ScreenMode;Lcom/larus/avlink/simulInterpret/page/model/Language;Lcom/larus/avlink/simulInterpret/page/model/Language;ZLjava/util/List;Ljava/util/List;Ljava/lang/Boolean;)V", "getScreenMode", "()Lcom/larus/avlink/simulInterpret/page/model/ScreenMode;", "getTopTranslateLanguage", "()Lcom/larus/avlink/simulInterpret/page/model/Language;", "getBottomTranslateLanguage", "()Z", "getTopTranslationResultList", "()Ljava/util/List;", "getBottomTranslationResultList", "getNeedRotated", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Lcom/larus/avlink/simulInterpret/page/model/ScreenMode;Lcom/larus/avlink/simulInterpret/page/model/Language;Lcom/larus/avlink/simulInterpret/page/model/Language;ZLjava/util/List;Ljava/util/List;Ljava/lang/Boolean;)Lcom/larus/avlink/simulInterpret/page/model/SimultaneousInterpretState;", "equals", "other", "", "hashCode", "", "toString", "", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SimultaneousInterpretState implements w1a.b {
    public static final int $stable = 8;
    private final a bottomTranslateLanguage;
    private final List<w> bottomTranslationResultList;
    private final boolean isSiMute;
    private final Boolean needRotated;
    private final b screenMode;
    private final a topTranslateLanguage;
    private final List<w> topTranslationResultList;

    public SimultaneousInterpretState() {
        this(null, null, null, false, null, null, null, 127, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SimultaneousInterpretState copy$default(SimultaneousInterpretState r100, b r101, a r102, a r103, boolean r104, List r110, List r111, Boolean r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = r100.screenMode;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.topTranslateLanguage;
    L8:
        a r115 = r102;
        if ((r113 & 4) == 0) goto L11;
        r103 = r100.bottomTranslateLanguage;
    L11:
        a r105 = r103;
        if ((r113 & 8) == 0) goto L14;
        r104 = r100.isSiMute;
    L14:
        boolean r106 = r104;
        if ((r113 & 16) == 0) goto L17;
        r110 = r100.topTranslationResultList;
    L17:
        List r107 = r110;
        if ((r113 & 32) == 0) goto L20;
        r111 = r100.bottomTranslationResultList;
    L20:
        List r108 = r111;
        if ((r113 & 64) == 0) goto L23;
        r112 = r100.needRotated;
    L23:
        b r109 = r101;
        return r100.copy(r109, r115, r105, r106, r107, r108, r112);
    }

    public final b component1() {
        return this.screenMode;
    }

    public final a component2() {
        return this.topTranslateLanguage;
    }

    public final a component3() {
        return this.bottomTranslateLanguage;
    }

    public final boolean component4() {
        return this.isSiMute;
    }

    public final List<w> component5() {
        return this.topTranslationResultList;
    }

    public final List<w> component6() {
        return this.bottomTranslationResultList;
    }

    public final Boolean component7() {
        return this.needRotated;
    }

    public final SimultaneousInterpretState copy(b r110, a r111, a r112, boolean r113, List<w> r114, List<w> r115, Boolean r116) {
        Intrinsics.checkNotNullParameter(r110, "screenMode");
        Intrinsics.checkNotNullParameter(r111, "topTranslateLanguage");
        Intrinsics.checkNotNullParameter(r112, "bottomTranslateLanguage");
        Intrinsics.checkNotNullParameter(r114, "topTranslationResultList");
        Intrinsics.checkNotNullParameter(r115, "bottomTranslationResultList");
        return new SimultaneousInterpretState(r110, r111, r112, r113, r114, r115, r116);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SimultaneousInterpretState) == true) goto L8;
        return false;
    L8:
        SimultaneousInterpretState r101 = (SimultaneousInterpretState) r100;
        if (Intrinsics.areEqual(this.screenMode, r101.screenMode) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.topTranslateLanguage, r101.topTranslateLanguage) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.bottomTranslateLanguage, r101.bottomTranslateLanguage) == true) goto L18;
        return false;
    L18:
        if (this.isSiMute == r101.isSiMute) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.topTranslationResultList, r101.topTranslationResultList) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.bottomTranslationResultList, r101.bottomTranslationResultList) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.needRotated, r101.needRotated) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        int r100 = ((((this.screenMode.hashCode() * 31) + this.topTranslateLanguage.hashCode()) * 31) + this.bottomTranslateLanguage.hashCode()) * 31;
        if (this.isSiMute == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = (((((r100 + r101) * 31) + this.topTranslationResultList.hashCode()) * 31) + this.bottomTranslationResultList.hashCode()) * 31;
        Boolean r103 = this.needRotated;
        if (r103 != null) goto L9;
        int r104 = 0;
    L11:
        return r102 + r104;
    L9:
        r104 = r103.hashCode();
        goto L11
    L5:
        r101 = 1237;
        goto L6
    }

    public String toString() {
        return "SimultaneousInterpretState(screenMode=" + this.screenMode + ", topTranslateLanguage=" + this.topTranslateLanguage + ", bottomTranslateLanguage=" + this.bottomTranslateLanguage + ", isSiMute=" + this.isSiMute + ", topTranslationResultList=" + this.topTranslationResultList + ", bottomTranslationResultList=" + this.bottomTranslationResultList + ", needRotated=" + this.needRotated + ')';
    }

    public final a getBottomTranslateLanguage() {
        return this.bottomTranslateLanguage;
    }

    public final List<w> getBottomTranslationResultList() {
        return this.bottomTranslationResultList;
    }

    public final Boolean getNeedRotated() {
        return this.needRotated;
    }

    public final b getScreenMode() {
        return this.screenMode;
    }

    public final a getTopTranslateLanguage() {
        return this.topTranslateLanguage;
    }

    public final List<w> getTopTranslationResultList() {
        return this.topTranslationResultList;
    }

    public final boolean isSiMute() {
        return this.isSiMute;
    }

    public SimultaneousInterpretState(b r100, a r101, a r102, boolean r103, List<w> r104, List<w> r105, Boolean r106) {
        Intrinsics.checkNotNullParameter(r100, "screenMode");
        Intrinsics.checkNotNullParameter(r101, "topTranslateLanguage");
        Intrinsics.checkNotNullParameter(r102, "bottomTranslateLanguage");
        Intrinsics.checkNotNullParameter(r104, "topTranslationResultList");
        Intrinsics.checkNotNullParameter(r105, "bottomTranslationResultList");
        this.screenMode = r100;
        this.topTranslateLanguage = r101;
        this.bottomTranslateLanguage = r102;
        this.isSiMute = r103;
        this.topTranslationResultList = r104;
        this.bottomTranslationResultList = r105;
        this.needRotated = r106;
    }

    public SimultaneousInterpretState(b r100, a r101, a r102, boolean r103, List r110, List r111, Boolean r112, int r113, DefaultConstructorMarker r114) {
        if ((r113 & 1) == 0) goto L14;
        if (d.f484397a == true) goto L7;
        r100 = b.C4012b.f294498a;
        goto L14
    L7:
        if (d.f484399c.isEmpty() == true) goto L9;
    L11:
        r100 = b.c.f294499a;
        goto L14
    L9:
        if (d.f484400d.isEmpty() == false) goto L11;
        r100 = b.a.f294497a;
    L14:
        if ((r113 & 2) == 0) goto L18;
        a r104 = a.f294491e;
        r101 = a.C4011a.b(d.d());
        if (r101 != null) goto L18;
        r101 = a.f294492f;
    L18:
        a r115 = r101;
        if ((r113 & 4) == 0) goto L24;
        a r105 = a.f294491e;
        a r106 = a.C4011a.b(d.c());
        if (r106 != null) goto L23;
        r106 = a.f294491e;
    L23:
        r102 = r106;
    L24:
        a r107 = r102;
        if ((r113 & 8) == 0) goto L27;
        r103 = DoraConfig.f331707a.getBoolean("key_si_mute", false);
    L27:
        boolean r108 = r103;
        if ((r113 & 16) == 0) goto L30;
        r110 = CollectionsKt.emptyList();
    L30:
        List r109 = r110;
        if ((r113 & 32) == 0) goto L33;
        r111 = CollectionsKt.emptyList();
    L33:
        List r116 = r111;
        if ((r113 & 64) == 0) goto L36;
        r112 = null;
    L36:
        b r117 = r100;
        this(r117, r115, r107, r108, r109, r116, r112);
    }
}
