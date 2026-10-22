package com.bytedance.flow_audio.api.business.tts.error;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.mammon.audiosdk.session.type.ResponseEvent;
import java.util.List;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
public final class FlowAudioAssistantError {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f243689a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f243690b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ErrorType f243691c;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/flow_audio/api/business/tts/error/FlowAudioAssistantError$ErrorType;", "", "rawValue", "", "<init>", "(Ljava/lang/String;II)V", "getRawValue", "()I", ResponseEvent.SessionFailed, ResponseEvent.TaskFailed, "ConnectFailed", "flow_audio_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ErrorType extends Enum<ErrorType> {
        public static final ErrorType ConnectFailed = null;
        public static final ErrorType SessionFailed = null;
        public static final ErrorType TaskFailed = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ErrorType[] f243692a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f243693b = null;
        private final int rawValue;

        public static EnumEntries<ErrorType> getEntries() {
            return f243693b;
        }

        static {
            ErrorType r100 = new ErrorType(ResponseEvent.SessionFailed, 0, 0);
            SessionFailed = r100;
            ErrorType r101 = new ErrorType(ResponseEvent.TaskFailed, 1, 1);
            TaskFailed = r101;
            ErrorType r102 = new ErrorType("ConnectFailed", 2, 2);
            ConnectFailed = r102;
            ErrorType[] r103 = {r100, r101, r102};
            f243692a = r103;
            f243693b = EnumEntriesKt.enumEntries(r103);
        }

        public static ErrorType[] values() {
            return (ErrorType[]) f243692a.clone();
        }

        public final int getRawValue() {
            return this.rawValue;
        }

        public static ErrorType valueOf(String r100) {
            return (ErrorType) a.a(ErrorType.class, r100);
        }

        public ErrorType(String r100, int r101, int r102) {
            super(r100, r101);
            this.rawValue = r102;
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof FlowAudioAssistantError) == true) goto L8;
        return false;
    L8:
        FlowAudioAssistantError r101 = (FlowAudioAssistantError) r100;
        if (Intrinsics.areEqual(this.f243689a, r101.f243689a) == true) goto L12;
        return false;
    L12:
        if (this.f243690b == r101.f243690b) goto L15;
        return false;
    L15:
        if (this.f243691c == r101.f243691c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f243689a.hashCode() * 31) + this.f243690b) * 31;
        ErrorType r101 = this.f243691c;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final Integer a() {
        List r100 = StringsKt.split$default(this.f243689a, new String[]{":"}, false, 0, 6, null);
        if (r100.size() == 3) goto L7;
        return null;
    L7:
        return StringsKt.toIntOrNull((String) ListProtector.get(r100, 1));
    }

    public final String b() {
        List r100 = StringsKt.split$default(this.f243689a, new String[]{":"}, false, 0, 6, null);
        if (r100.size() == 3) goto L5;
        return null;
    L5:
        String r101 = (String) ListProtector.get(r100, 2);
        if (r101.length() != 0) goto L8;
        boolean r102 = true;
    L9:
        if (r102 == false) goto L12;
        return null;
    L12:
        return r101;
    L8:
        r102 = false;
        goto L9
    }

    public final String toString() {
        return "[name=" + this.f243689a + ", status:" + this.f243690b + ", errorType=" + this.f243691c + ']';
    }

    public FlowAudioAssistantError(String r100, int r101, ErrorType r102) {
        Intrinsics.checkNotNullParameter(r100, "name");
        this.f243689a = r100;
        this.f243690b = r101;
        this.f243691c = r102;
    }
}
