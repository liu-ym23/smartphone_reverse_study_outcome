package com.larus.business.markdown.api.model;

import androidx.autofill.HintConstants;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BB\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012%\b\u0002\u0010\u0006\u001a\u001f\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007¢\u0006\u0002\u0010\u000bJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J&\u0010\u0014\u001a\u001f\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007HÆ\u0003JF\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052%\b\u0002\u0010\u0006\u001a\u001f\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR.\u0010\u0006\u001a\u001f\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001b"}, d2 = {"Lcom/larus/business/markdown/api/model/PhoneNumberConfig;", "", "enableHighlight", "", "phoneRegex", "", "linkGenerator", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", HintConstants.AUTOFILL_HINT_PHONE_NUMBER, "(ZLjava/lang/String;Lkotlin/jvm/functions/Function1;)V", "getEnableHighlight", "()Z", "getLinkGenerator", "()Lkotlin/jvm/functions/Function1;", "getPhoneRegex", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "markdown-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PhoneNumberConfig {
    private final boolean enableHighlight;
    private final Function1<String, String> linkGenerator;
    private final String phoneRegex;

    public PhoneNumberConfig() {
        this(false, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PhoneNumberConfig copy$default(PhoneNumberConfig r100, boolean r101, String r102, Function1 r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.enableHighlight;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.phoneRegex;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.linkGenerator;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final boolean component1() {
        return this.enableHighlight;
    }

    public final String component2() {
        return this.phoneRegex;
    }

    public final Function1<String, String> component3() {
        return this.linkGenerator;
    }

    public final PhoneNumberConfig copy(boolean r100, String r101, Function1<? super String, String> r102) {
        return new PhoneNumberConfig(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PhoneNumberConfig) == true) goto L8;
        return false;
    L8:
        PhoneNumberConfig r101 = (PhoneNumberConfig) r100;
        if (this.enableHighlight == r101.enableHighlight) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.phoneRegex, r101.phoneRegex) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.linkGenerator, r101.linkGenerator) == true) goto L17;
        return false;
    L17:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        boolean r100 = this.enableHighlight;
        ?? r101 = r100;
        if (r100 == false) goto L5;
        r101 = 1;
    L5:
        int r102 = r101 * 31;
        String r103 = this.phoneRegex;
        int r104 = 0;
        if (r103 != null) goto L8;
        int r105 = 0;
    L9:
        int r106 = (r102 + r105) * 31;
        Function1<String, String> r107 = this.linkGenerator;
        if (r107 == null) goto L14;
        r104 = r107.hashCode();
    L14:
        return r106 + r104;
    L8:
        r105 = r103.hashCode();
        goto L9
    }

    public String toString() {
        return "PhoneNumberConfig(enableHighlight=" + this.enableHighlight + ", phoneRegex=" + this.phoneRegex + ", linkGenerator=" + this.linkGenerator + ')';
    }

    public final boolean getEnableHighlight() {
        return this.enableHighlight;
    }

    public final Function1<String, String> getLinkGenerator() {
        return this.linkGenerator;
    }

    public final String getPhoneRegex() {
        return this.phoneRegex;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PhoneNumberConfig(boolean r100, String r101, Function1<? super String, String> r102) {
        this.enableHighlight = r100;
        this.phoneRegex = r101;
        this.linkGenerator = r102;
    }

    public /* synthetic */ PhoneNumberConfig(boolean r100, String r101, Function1 r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
