package com.larus.bmhome.nestedfile;

import androidx.lifecycle.MutableLiveData;
import com.larus.im.bean.message.FileParseState;
import com.larus.im.bean.message.FileReviewState;
import com.larus.im.bean.message.NestedFileContent;
import com.larus.im.bean.message.UpLinkState;
import com.larus.im.bean.message.UplinkFileEntity;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import lr8.d;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001:\u0001*J\u0018\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0004H&J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H&J\"\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r0\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0018\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u000fH&J\u0018\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0006H&J\u0018\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u000fH&J\u0018\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u000fH&J\u0018\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0018H&J \u0010\u0019\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u001bH&J\u0010\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u001eH&JH\u0010\u001f\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00062\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0006H&J\u001a\u0010'\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0006H&J\u0018\u0010(\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0006H&J\u0018\u0010)\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0006H\u0016¨\u0006+"}, d2 = {"Lcom/larus/bmhome/nestedfile/INestedFileCacheManagerService;", "", "getOrCreateNestedFileLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/larus/im/bean/message/NestedFileContent;", "localMsgID", "", "insertOrReplaceNestedFile", "", "content", "removeNestedFile", "getNestedFile", "getOrCreateFileLiveData", "Lkotlin/Pair;", "Lcom/larus/bmhome/nestedfile/INestedFileCacheManagerService$FileEvent;", "Lcom/larus/im/bean/message/UplinkFileEntity;", "insertFile", "removeFile", "fileIdentifier", "replaceFile", "updateUplinkFileEntity", "updateFileEntity", "updateUplinkFileInfo", "updateFileInfo", "Lcom/larus/bmhome/nestedfile/NestedFileUplinkUpdateInfo;", "updateFileUpLinkProcess", "process", "", "updateFileStateFromCMD", "info", "Lcom/larus/bmhome/nestedfile/UpdateNestedMessageDownLinkInfo;", "updateFileState", "upLinkState", "Lcom/larus/im/bean/message/UpLinkState;", "fileReviewState", "Lcom/larus/im/bean/message/FileReviewState;", "fileParseState", "Lcom/larus/im/bean/message/FileParseState;", "audioDetailUrl", "getFile", "insertRemovedFile", "removeRemovedFile", "FileEvent", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface INestedFileCacheManagerService {

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/bmhome/nestedfile/INestedFileCacheManagerService$FileEvent;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "INSERT", "REMOVE", "UPDATE", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum FileEvent extends Enum<FileEvent> {
        public static final FileEvent INSERT = null;
        public static final FileEvent REMOVE = null;
        public static final FileEvent UPDATE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ FileEvent[] f313405a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f313406b = null;
        private final int value;

        public static EnumEntries<FileEvent> getEntries() {
            return f313406b;
        }

        static {
            FileEvent r100 = new FileEvent("INSERT", 0, 0);
            INSERT = r100;
            FileEvent r101 = new FileEvent("REMOVE", 1, 1);
            REMOVE = r101;
            FileEvent r102 = new FileEvent("UPDATE", 2, 2);
            UPDATE = r102;
            FileEvent[] r103 = {r100, r101, r102};
            f313405a = r103;
            f313406b = EnumEntriesKt.enumEntries(r103);
        }

        public static FileEvent[] values() {
            return (FileEvent[]) f313405a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static FileEvent valueOf(String r100) {
            return (FileEvent) r27.a.a(FileEvent.class, r100);
        }

        public FileEvent(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class a {
        public static /* synthetic */ void a(INestedFileCacheManagerService r100, String r110, String r111, UpLinkState r112, FileReviewState r113, FileParseState r114, int r115) {
            if ((r115 & 4) == 0) goto L5;
            UpLinkState r101 = null;
        L7:
            if ((r115 & 8) == 0) goto L9;
            FileReviewState r102 = null;
        L11:
            if ((r115 & 16) == 0) goto L13;
            FileParseState r103 = null;
        L14:
            r100.d(r110, r111, r101, r102, r103, null);
            return;
        L13:
            r103 = r114;
            goto L14
        L9:
            r102 = r113;
            goto L11
        L5:
            r101 = r112;
            goto L7
        }
    }

    UplinkFileEntity a(String r100, String r101);

    void b(String r100, String r101);

    void b2(String r100);

    NestedFileContent b6(String r100);

    void c(String r100, UplinkFileEntity r101);

    void d(String r100, String r101, UpLinkState r102, FileReviewState r103, FileParseState r104, String r105);

    void e(UpdateNestedMessageDownLinkInfo r100);

    void f(String r100, d r101);

    MutableLiveData<Pair<FileEvent, UplinkFileEntity>> g(String r100);

    void h(String r100, String r101);

    void i(String r100, NestedFileContent r101);

    MutableLiveData<NestedFileContent> j(String r100);

    void k(String r100, UplinkFileEntity r101);

    void l(String r100, UplinkFileEntity r101);

    void m(String r100, String r101, int r102);

    void n(String r100, String r101);
}
