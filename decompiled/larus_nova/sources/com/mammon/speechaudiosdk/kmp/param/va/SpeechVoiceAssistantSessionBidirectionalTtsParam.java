package com.mammon.speechaudiosdk.kmp.param.va;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/mammon/speechaudiosdk/kmp/param/va/SpeechVoiceAssistantSessionBidirectionalTtsParam;", "", "text", "", "<init>", "(Ljava/lang/String;)V", "getText", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "speech_audiosdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SpeechVoiceAssistantSessionBidirectionalTtsParam {
    private final String text;

    /* JADX WARN: Multi-variable type inference failed */
    public SpeechVoiceAssistantSessionBidirectionalTtsParam() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ SpeechVoiceAssistantSessionBidirectionalTtsParam copy$default(SpeechVoiceAssistantSessionBidirectionalTtsParam r100, String r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.text;
    L6:
        return r100.copy(r101);
    }

    public final String component1() {
        return this.text;
    }

    public final SpeechVoiceAssistantSessionBidirectionalTtsParam copy(String r100) {
        return new SpeechVoiceAssistantSessionBidirectionalTtsParam(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SpeechVoiceAssistantSessionBidirectionalTtsParam) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.text, ((SpeechVoiceAssistantSessionBidirectionalTtsParam) r100).text) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        String r100 = this.text;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public String toString() {
        return "SpeechVoiceAssistantSessionBidirectionalTtsParam(text=" + this.text + ')';
    }

    public final String getText() {
        return this.text;
    }

    public SpeechVoiceAssistantSessionBidirectionalTtsParam(String r100) {
        this.text = r100;
    }

    public /* synthetic */ SpeechVoiceAssistantSessionBidirectionalTtsParam(String r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}
