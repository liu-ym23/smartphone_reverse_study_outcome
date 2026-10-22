package com.larus.im.internal.jni;

import com.larus.im.internal.database.dao.BotDao;
import com.larus.im.internal.database.dao.ConversationDao;
import com.larus.im.internal.database.dao.DBIndexDAO;
import com.larus.im.internal.database.dao.MessageDao;
import com.larus.im.internal.database.dao.ParticipantDao;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\b\u0010\u001a\u001a\u00020\u0014H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/larus/im/internal/jni/NativeIMDatabase;", "Lcom/larus/im/internal/database/IMDatabase;", "helper", "Lcom/larus/im/internal/jni/NativeOmniIMSDKHelper;", "dbName", "", "dbPath", "<init>", "(Lcom/larus/im/internal/jni/NativeOmniIMSDKHelper;Ljava/lang/String;Ljava/lang/String;)V", "omnisdk", "Lcom/larus/im/internal/jni/OmniCppHelper;", "messageDao", "Lcom/larus/im/internal/database/dao/MessageDao;", "conversationDao", "Lcom/larus/im/internal/database/dao/ConversationDao;", "botDao", "Lcom/larus/im/internal/database/dao/BotDao;", "participantDao", "Lcom/larus/im/internal/database/dao/ParticipantDao;", "indexDao", "Lcom/larus/im/internal/database/dao/DBIndexDAO;", "release", "", "drop", "", "releaseDb", "getDBIndexDAO", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NativeIMDatabase implements com.larus.im.internal.database.b {
    private final OmniCppHelper omnisdk;

    private final DBIndexDAO getDBIndexDAO() {
        return this.omnisdk.getIndexDAO();
    }

    @Override // com.larus.im.internal.database.b
    public BotDao botDao() {
        return this.omnisdk.getBotDAO();
    }

    @Override // com.larus.im.internal.database.b
    public ConversationDao conversationDao() {
        return this.omnisdk.getConversationDAO();
    }

    @Override // com.larus.im.internal.database.b
    public MessageDao messageDao() {
        return this.omnisdk.getMessageDAO();
    }

    @Override // com.larus.im.internal.database.b
    public ParticipantDao participantDao() {
        return this.omnisdk.getParticipantDAO();
    }

    @Override // com.larus.im.internal.database.b
    public DBIndexDAO indexDao() {
        return getDBIndexDAO();
    }

    private final void releaseDb(boolean r100) {
        this.omnisdk.releaseDb(r100);
    }

    public void release(boolean r100) {
        releaseDb(r100);
    }

    public NativeIMDatabase(NativeOmniIMSDKHelper r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "helper");
        Intrinsics.checkNotNullParameter(r101, "dbName");
        Intrinsics.checkNotNullParameter(r102, "dbPath");
        this.omnisdk = new OmniCppHelper(r102);
    }
}
