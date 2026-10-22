package com.ss.android.lark.chat.entity.message.content;

import com.larus.nova.R;
import com.ss.android.download.api.config.HttpMethod;

/* JADX INFO: loaded from: classes35.dex */
public final enum FileState extends Enum<FileState> {
    public static final FileState COMPRESSING = null;
    public static final FileState DONE = null;
    public static final FileState DOWNLOAD = null;
    public static final FileState DOWNLOADING = null;
    public static final FileState PAUSE = null;
    public static final FileState UPLOADING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FileState[] f415337a = null;
    private int fileStateType;
    private int value;

    static {
        FileState r100 = new FileState(HttpMethod.DOWNLOAD, 0, 1, R.string.Lark_Legacy_FileStateDownload);
        DOWNLOAD = r100;
        FileState r101 = new FileState("DOWNLOADING", 1, 2, R.string.Lark_Legacy_FileStateDownloading);
        DOWNLOADING = r101;
        FileState r102 = new FileState("UPLOADING", 2, 3, R.string.Lark_Legacy_FileStateUploading);
        UPLOADING = r102;
        FileState r103 = new FileState("COMPRESSING", 3, 4, R.string.Lark_Legacy_FileStateCompressing);
        COMPRESSING = r103;
        FileState r104 = new FileState("PAUSE", 4, 5, R.string.Lark_Legacy_FileStatePause);
        PAUSE = r104;
        FileState r105 = new FileState("DONE", 5, 6, R.string.Lark_Legacy_FileStateDone);
        DONE = r105;
        f415337a = new FileState[]{r100, r101, r102, r103, r104, r105};
    }

    public static FileState[] values() {
        return (FileState[]) f415337a.clone();
    }

    public int getFileStateType() {
        return this.fileStateType;
    }

    public int getValue() {
        return this.value;
    }

    public static FileState valueOf(String r100) {
        return (FileState) r27.a.a(FileState.class, r100);
    }

    public FileState(String r100, int r101, int r102, int r103) {
        super(r100, r101);
        this.fileStateType = r102;
        this.value = r103;
    }
}
