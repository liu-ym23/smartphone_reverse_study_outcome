package com.ss.android.lark.chat.entity.message.content;

import androidx.exifinterface.media.ExifInterface;
import com.ss.android.lark.chat.entity.message.content.BaseFileContent;
import com.ss.android.lark.chat.export.entity.message.Content;
import com.ss.android.lark.image.entity.ResourceCleanScene;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import y28.b;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b&\u0018\u0000 G*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00002\u00020\u0002:\u0003EFGB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0006\u0010@\u001a\u00020#J\b\u0010A\u001a\u0004\u0018\u00010:J\u0012\u0010B\u001a\u00020#2\b\u0010C\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010D\u001a\u00020#2\b\u0010C\u001a\u0004\u0018\u00010\u0002H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\b\"\u0004\b\u0016\u0010\nR$\u0010\u0017\u001a\u00020\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR \u0010\u001e\u001a\u00020\u0018X\u0086\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001f\u0010\u0004\u001a\u0004\b \u0010\u001b\"\u0004\b!\u0010\u001dR\u001a\u0010\"\u001a\u00020#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010$\"\u0004\b%\u0010&R\u0011\u0010'\u001a\u00020#8F¢\u0006\u0006\u001a\u0004\b'\u0010$R$\u0010(\u001a\u00020\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b)\u0010\u0004\u001a\u0004\b*\u0010\u001b\"\u0004\b+\u0010\u001dR\u001a\u0010,\u001a\u00020#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010$\"\u0004\b-\u0010&R\u0011\u0010.\u001a\u00020#8F¢\u0006\u0006\u001a\u0004\b.\u0010$R\u001b\u0010/\u001a\u00020#8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b/\u0010$R\u001c\u00102\u001a\u0004\u0018\u000103X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R6\u00108\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020:09j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020:`;X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?¨\u0006H"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/content/BaseFileContent;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/ss/android/lark/chat/export/entity/message/Content;", "<init>", "()V", "key", "", "getKey", "()Ljava/lang/String;", "setKey", "(Ljava/lang/String;)V", "name", "getName", "setName", "size", "", "getSize", "()J", "setSize", "(J)V", "nameSpace", "getNameSpace", "setNameSpace", "source", "", "getSource$annotations", "getSource", "()I", "setSource", "(I)V", "saveToDrive", "getSaveToDrive$annotations", "getSaveToDrive", "setSaveToDrive", "isInMyNutStore", "", "()Z", "setInMyNutStore", "(Z)V", "isFromDrive", "lanTransStatus", "getLanTransStatus$annotations", "getLanTransStatus", "setLanTransStatus", "isSender", "setSender", "isLanTransfer", "isLanTransferring", "isLanTransferring$delegate", "Lkotlin/Lazy;", "filePreviewStage", "Lcom/ss/android/lark/chat/entity/message/content/FilePreviewStage;", "getFilePreviewStage", "()Lcom/ss/android/lark/chat/entity/message/content/FilePreviewStage;", "setFilePreviewStage", "(Lcom/ss/android/lark/chat/entity/message/content/FilePreviewStage;)V", "cleanResourceKeyScene", "Ljava/util/HashMap;", "Lcom/ss/android/lark/image/entity/ResourceCleanScene;", "Lkotlin/collections/HashMap;", "getCleanResourceKeyScene", "()Ljava/util/HashMap;", "setCleanResourceKeyScene", "(Ljava/util/HashMap;)V", "resourceIsCleaned", "currentResourceScene", "isContentSame", "diffable", "isItemSame", "Source", "TransStatus", "Companion", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class BaseFileContent<T extends BaseFileContent<T>> extends Content {
    public static final int ABORT_BY_RECEIVER = 5;
    public static final int ABORT_BY_SENDER = 4;
    public static final int ACCEPT = 1;
    public static final int CANCEL = 3;
    public static final a Companion = null;
    public static final int LAN_TRANS = 3;
    public static final int LARK_SERVER = 1;
    public static final int OFFLINE_MODE = 7;
    public static final int PENDING = 0;
    public static final int REFUSE = 2;
    public static final int SOURCE_NUT_STORE = 2;
    public static final int SOURCE_UNKNOWN = 0;
    public static final int TRANS_DONE = 6;
    private HashMap<String, ResourceCleanScene> cleanResourceKeyScene;
    private FilePreviewStage filePreviewStage;
    private boolean isInMyNutStore;
    private final Lazy isLanTransferring$delegate;
    private boolean isSender;
    private String key;
    private int lanTransStatus;
    private String name;
    private String nameSpace;
    private int saveToDrive;
    private long size;
    private int source;

    @Retention(RetentionPolicy.SOURCE)
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/content/BaseFileContent$Source;", "", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public @interface Source {
    }

    @Retention(RetentionPolicy.SOURCE)
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/content/BaseFileContent$TransStatus;", "", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public @interface TransStatus {
    }

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ void getLanTransStatus$annotations() {
    }

    public static /* synthetic */ void getSaveToDrive$annotations() {
    }

    public static /* synthetic */ void getSource$annotations() {
    }

    public final ResourceCleanScene currentResourceScene() {
        ResourceCleanScene r100 = this.cleanResourceKeyScene.get(this.key);
        if (r100 == null) goto L5;
        return r100;
    L5:
        return (ResourceCleanScene) CollectionsKt.firstOrNull(this.cleanResourceKeyScene.values());
    }

    public final boolean isFromDrive() {
        if (this.source != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isLanTransfer() {
        if (this.source != 3) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isLanTransferring() {
        return ((Boolean) this.isLanTransferring$delegate.getValue()).booleanValue();
    }

    public final boolean resourceIsCleaned() {
        return !this.cleanResourceKeyScene.isEmpty();
    }

    public BaseFileContent() {
        this.key = "";
        this.name = "";
        this.source = 1;
        this.saveToDrive = -1;
        this.isLanTransferring$delegate = LazyKt.lazy(new AnonymousClass2(this));
        this.filePreviewStage = FilePreviewStage.UnknownStage;
        this.cleanResourceKeyScene = new HashMap();
    }

    public final HashMap<String, ResourceCleanScene> getCleanResourceKeyScene() {
        return this.cleanResourceKeyScene;
    }

    public final FilePreviewStage getFilePreviewStage() {
        return this.filePreviewStage;
    }

    public final String getKey() {
        return this.key;
    }

    public final int getLanTransStatus() {
        return this.lanTransStatus;
    }

    public final String getName() {
        return this.name;
    }

    public final String getNameSpace() {
        return this.nameSpace;
    }

    public final int getSaveToDrive() {
        return this.saveToDrive;
    }

    public final long getSize() {
        return this.size;
    }

    public final int getSource() {
        return this.source;
    }

    public final boolean isInMyNutStore() {
        return this.isInMyNutStore;
    }

    public final boolean isSender() {
        return this.isSender;
    }

    @Override // com.ss.android.lark.chat.export.entity.message.Content
    public boolean isContentSame(Content r100) {
        if ((r100 instanceof BaseFileContent) == false) goto L13;
        BaseFileContent r101 = (BaseFileContent) r100;
        if (this.source != r101.source) goto L13;
        if (this.lanTransStatus != r101.lanTransStatus) goto L13;
        if (this.isSender != r101.isSender) goto L13;
        if (Intrinsics.areEqual(this.cleanResourceKeyScene, r101.cleanResourceKeyScene) == false) goto L13;
        return true;
    L13:
        return false;
    }

    @Override // com.ss.android.lark.chat.export.entity.message.Content
    public boolean isItemSame(Content r100) {
        if (r100 != null) goto L4;
    L8:
        return false;
    L4:
        if ((r100 instanceof BaseFileContent) == false) goto L8;
        if (Intrinsics.areEqual(this.key, ((BaseFileContent) r100).key) == false) goto L8;
        return true;
    }

    public final void setCleanResourceKeyScene(HashMap<String, ResourceCleanScene> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.cleanResourceKeyScene = r100;
    }

    public final void setFilePreviewStage(FilePreviewStage r100) {
        this.filePreviewStage = r100;
    }

    public final void setInMyNutStore(boolean r100) {
        this.isInMyNutStore = r100;
    }

    public final void setKey(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.key = r100;
    }

    public final void setLanTransStatus(int r100) {
        this.lanTransStatus = r100;
    }

    public final void setName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.name = r100;
    }

    public final void setNameSpace(String r100) {
        this.nameSpace = r100;
    }

    public final void setSaveToDrive(int r100) {
        this.saveToDrive = r100;
    }

    public final void setSender(boolean r100) {
        this.isSender = r100;
    }

    public final void setSize(long r100) {
        this.size = r100;
    }

    public final void setSource(int r100) {
        this.source = r100;
    }

    @Override // com.ss.android.lark.chat.export.entity.message.Content, y28.b
    public /* bridge */ /* synthetic */ boolean isContentSame(b r100) {
        return isContentSame((Content) r100);
    }

    @Override // com.ss.android.lark.chat.export.entity.message.Content, y28.b
    public /* bridge */ /* synthetic */ boolean isItemSame(b r100) {
        return isItemSame((Content) r100);
    }
}
