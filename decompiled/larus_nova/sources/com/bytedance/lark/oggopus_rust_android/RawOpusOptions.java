package com.bytedance.lark.oggopus_rust_android;

import kotlin.Metadata;
import kotlin.UInt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u0016\u0010\u0013\u001a\u00020\u0003HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\tJ\u0016\u0010\u0015\u001a\u00020\u0003HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\tJ\u0016\u0010\u0017\u001a\u00020\u0003HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\tJ\u0016\u0010\u0019\u001a\u00020\u0003HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\tJ;\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\u0006\u0010#\u001a\u00020$J\t\u0010%\u001a\u00020&HÖ\u0001R\"\u0010\u0002\u001a\u00020\u0003X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\u0005\u001a\u00020\u0003X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\"\u0010\u0004\u001a\u00020\u0003X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\u000f\u0010\t\"\u0004\b\u0010\u0010\u000bR\"\u0010\u0006\u001a\u00020\u0003X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\u0011\u0010\t\"\u0004\b\u0012\u0010\u000b\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006'"}, d2 = {"Lcom/bytedance/lark/oggopus_rust_android/RawOpusOptions;", "", "bitrateBps", "Lkotlin/UInt;", "frameMs", "channels", "inputRateHz", "(IIIILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getBitrateBps-pVg5ArA", "()I", "setBitrateBps-WZ4Q5Ns", "(I)V", "I", "getChannels-pVg5ArA", "setChannels-WZ4Q5Ns", "getFrameMs-pVg5ArA", "setFrameMs-WZ4Q5Ns", "getInputRateHz-pVg5ArA", "setInputRateHz-WZ4Q5Ns", "component1", "component1-pVg5ArA", "component2", "component2-pVg5ArA", "component3", "component3-pVg5ArA", "component4", "component4-pVg5ArA", "copy", "copy-nAmpug0", "(IIII)Lcom/bytedance/lark/oggopus_rust_android/RawOpusOptions;", "equals", "", "other", "hashCode", "", "into", "Loggopus_rust/proto/RawOpusOptions;", "toString", "", "oggopus_rust_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class RawOpusOptions {
    private int bitrateBps;
    private int channels;
    private int frameMs;
    private int inputRateHz;

    public /* synthetic */ RawOpusOptions(int r100, int r101, int r102, int r103, DefaultConstructorMarker r104) {
        this(r100, r101, r102, r103);
    }

    /* JADX INFO: renamed from: copy-nAmpug0$default, reason: not valid java name */
    public static /* synthetic */ RawOpusOptions m8458copynAmpug0$default(RawOpusOptions r100, int r101, int r102, int r103, int r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.bitrateBps;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.frameMs;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.channels;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.inputRateHz;
    L15:
        return r100.m8463copynAmpug0(r101, r102, r103, r104);
    }

    /* JADX INFO: renamed from: component1-pVg5ArA, reason: not valid java name */
    public final int m8459component1pVg5ArA() {
        return this.bitrateBps;
    }

    /* JADX INFO: renamed from: component2-pVg5ArA, reason: not valid java name */
    public final int m8460component2pVg5ArA() {
        return this.frameMs;
    }

    /* JADX INFO: renamed from: component3-pVg5ArA, reason: not valid java name */
    public final int m8461component3pVg5ArA() {
        return this.channels;
    }

    /* JADX INFO: renamed from: component4-pVg5ArA, reason: not valid java name */
    public final int m8462component4pVg5ArA() {
        return this.inputRateHz;
    }

    /* JADX INFO: renamed from: copy-nAmpug0, reason: not valid java name */
    public final RawOpusOptions m8463copynAmpug0(int r100, int r101, int r110, int r111) {
        return new RawOpusOptions(r100, r101, r110, r111, null);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof RawOpusOptions) == true) goto L8;
        return false;
    L8:
        RawOpusOptions r101 = (RawOpusOptions) r100;
        if (this.bitrateBps == r101.bitrateBps) goto L12;
        return false;
    L12:
        if (this.frameMs == r101.frameMs) goto L15;
        return false;
    L15:
        if (this.channels == r101.channels) goto L18;
        return false;
    L18:
        if (this.inputRateHz == r101.inputRateHz) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((UInt.m9556hashCodeimpl(this.bitrateBps) * 31) + UInt.m9556hashCodeimpl(this.frameMs)) * 31) + UInt.m9556hashCodeimpl(this.channels)) * 31) + UInt.m9556hashCodeimpl(this.inputRateHz);
    }

    public String toString() {
        return "RawOpusOptions(bitrateBps=" + UInt.m9590toStringimpl(this.bitrateBps) + ", frameMs=" + UInt.m9590toStringimpl(this.frameMs) + ", channels=" + UInt.m9590toStringimpl(this.channels) + ", inputRateHz=" + UInt.m9590toStringimpl(this.inputRateHz) + ')';
    }

    public final oggopus_rust.proto.RawOpusOptions into() {
        return new oggopus_rust.proto.RawOpusOptions(Integer.valueOf(this.bitrateBps), Integer.valueOf(this.frameMs), Integer.valueOf(this.channels), Integer.valueOf(this.inputRateHz));
    }

    /* JADX INFO: renamed from: getBitrateBps-pVg5ArA, reason: not valid java name */
    public final int m8464getBitrateBpspVg5ArA() {
        return this.bitrateBps;
    }

    /* JADX INFO: renamed from: getChannels-pVg5ArA, reason: not valid java name */
    public final int m8465getChannelspVg5ArA() {
        return this.channels;
    }

    /* JADX INFO: renamed from: getFrameMs-pVg5ArA, reason: not valid java name */
    public final int m8466getFrameMspVg5ArA() {
        return this.frameMs;
    }

    /* JADX INFO: renamed from: getInputRateHz-pVg5ArA, reason: not valid java name */
    public final int m8467getInputRateHzpVg5ArA() {
        return this.inputRateHz;
    }

    /* JADX INFO: renamed from: setBitrateBps-WZ4Q5Ns, reason: not valid java name */
    public final void m8468setBitrateBpsWZ4Q5Ns(int r100) {
        this.bitrateBps = r100;
    }

    /* JADX INFO: renamed from: setChannels-WZ4Q5Ns, reason: not valid java name */
    public final void m8469setChannelsWZ4Q5Ns(int r100) {
        this.channels = r100;
    }

    /* JADX INFO: renamed from: setFrameMs-WZ4Q5Ns, reason: not valid java name */
    public final void m8470setFrameMsWZ4Q5Ns(int r100) {
        this.frameMs = r100;
    }

    /* JADX INFO: renamed from: setInputRateHz-WZ4Q5Ns, reason: not valid java name */
    public final void m8471setInputRateHzWZ4Q5Ns(int r100) {
        this.inputRateHz = r100;
    }

    private RawOpusOptions(int r100, int r101, int r102, int r103) {
        this.bitrateBps = r100;
        this.frameMs = r101;
        this.channels = r102;
        this.inputRateHz = r103;
    }
}
