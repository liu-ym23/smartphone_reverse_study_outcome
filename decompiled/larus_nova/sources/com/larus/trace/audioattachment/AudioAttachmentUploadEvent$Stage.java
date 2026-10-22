package com.larus.trace.audioattachment;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/larus/trace/audioattachment/AudioAttachmentUploadEvent$Stage;", "", "value", "", "phase", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "getPhase", "SELECTED", "VALIDATION", "CACHE", "UPLOAD", "PATH", "READY", "SEND", "SENT", "trace_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AudioAttachmentUploadEvent$Stage extends Enum<AudioAttachmentUploadEvent$Stage> {
    public static final AudioAttachmentUploadEvent$Stage CACHE = null;
    public static final AudioAttachmentUploadEvent$Stage PATH = null;
    public static final AudioAttachmentUploadEvent$Stage READY = null;
    public static final AudioAttachmentUploadEvent$Stage SELECTED = null;
    public static final AudioAttachmentUploadEvent$Stage SEND = null;
    public static final AudioAttachmentUploadEvent$Stage SENT = null;
    public static final AudioAttachmentUploadEvent$Stage UPLOAD = null;
    public static final AudioAttachmentUploadEvent$Stage VALIDATION = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AudioAttachmentUploadEvent$Stage[] f370161a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f370162b = null;
    private final String phase;
    private final String value;

    public static EnumEntries<AudioAttachmentUploadEvent$Stage> getEntries() {
        return f370162b;
    }

    static {
        AudioAttachmentUploadEvent$Stage r100 = new AudioAttachmentUploadEvent$Stage("SELECTED", 0, "attachment_selected", "resource");
        SELECTED = r100;
        AudioAttachmentUploadEvent$Stage r101 = new AudioAttachmentUploadEvent$Stage("VALIDATION", 1, "audio_validation_resolved", "resource");
        VALIDATION = r101;
        AudioAttachmentUploadEvent$Stage r102 = new AudioAttachmentUploadEvent$Stage("CACHE", 2, "local_cache_resolved", "resource");
        CACHE = r102;
        AudioAttachmentUploadEvent$Stage r103 = new AudioAttachmentUploadEvent$Stage("UPLOAD", 3, "upload_dispatched", "resource");
        UPLOAD = r103;
        AudioAttachmentUploadEvent$Stage r104 = new AudioAttachmentUploadEvent$Stage("PATH", 4, "upload_path_resolved", "resource");
        PATH = r104;
        AudioAttachmentUploadEvent$Stage r105 = new AudioAttachmentUploadEvent$Stage("READY", 5, "resource_ready", "resource");
        READY = r105;
        AudioAttachmentUploadEvent$Stage r106 = new AudioAttachmentUploadEvent$Stage("SEND", 6, "im_send_dispatched", "message");
        SEND = r106;
        AudioAttachmentUploadEvent$Stage r110 = new AudioAttachmentUploadEvent$Stage("SENT", 7, "im_send_result", "message");
        SENT = r110;
        AudioAttachmentUploadEvent$Stage[] r111 = {r100, r101, r102, r103, r104, r105, r106, r110};
        f370161a = r111;
        f370162b = EnumEntriesKt.enumEntries(r111);
    }

    public static AudioAttachmentUploadEvent$Stage[] values() {
        return (AudioAttachmentUploadEvent$Stage[]) f370161a.clone();
    }

    public final String getPhase() {
        return this.phase;
    }

    public final String getValue() {
        return this.value;
    }

    public static AudioAttachmentUploadEvent$Stage valueOf(String r100) {
        return (AudioAttachmentUploadEvent$Stage) a.a(AudioAttachmentUploadEvent$Stage.class, r100);
    }

    public AudioAttachmentUploadEvent$Stage(String r100, int r101, String r102, String r103) {
        super(r100, r101);
        this.value = r102;
        this.phase = r103;
    }
}
