package com.larus.im.internal.jni;

import android.content.Context;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.im.internal.database.dao.BotDao;
import com.larus.im.internal.database.dao.ConversationDao;
import com.larus.im.internal.database.dao.DBIndexDAO;
import com.larus.im.internal.database.dao.MessageDao;
import com.larus.im.internal.database.dao.ParticipantDao;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0000\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\b\u001a\u00020\tJ\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u0016\u001a\u00020\u0015J\u0011\u0010\b\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0003H\u0082 J\u0011\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u0003H\u0082 J\u0011\u0010\f\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0003H\u0082 J\u0011\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0003H\u0082 J\u0011\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0003H\u0082 J\u0019\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0015H\u0082 J\u0011\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0003H\u0082 R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u001c"}, d2 = {"Lcom/larus/im/internal/jni/OmniCppHelper;", "", "path", "", "<init>", "(Ljava/lang/String;)V", "getPath", "()Ljava/lang/String;", "getMessageDAO", "Lcom/larus/im/internal/database/dao/MessageDao;", "getBotDAO", "Lcom/larus/im/internal/database/dao/BotDao;", "getConversationDAO", "Lcom/larus/im/internal/database/dao/ConversationDao;", "getParticipantDAO", "Lcom/larus/im/internal/database/dao/ParticipantDao;", "getIndexDAO", "Lcom/larus/im/internal/database/dao/DBIndexDAO;", "releaseDb", "", "drop", "", "dropMessageFtsTable", "dbPath", "releaseDbInternal", "", "dropAndResetMessageFtsTableInternal", "Companion", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OmniCppHelper {
    public static final Companion Companion = null;
    private static final String TAG = "OmniCppHelper";
    private final String path;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0002R\u000e\u0010\f\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/larus/im/internal/jni/OmniCppHelper$Companion;", "", "<init>", "()V", "getDataDirFile", "Ljava/io/File;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "getDatabasesDir", "buildDbPath", "", "dbName", "TAG", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        private final File getDataDirFile(Context r100) {
            String r101 = r100.getApplicationInfo().dataDir;
            if (r101 != null) goto L7;
            return null;
        L7:
            return new PolarisFileWrapper(r101);
        }

        private final File getDatabasesDir(Context r100) {
            PolarisFileWrapper r101 = new PolarisFileWrapper(getDataDirFile(r100), "databases");
            if (Intrinsics.areEqual(r101.getPath(), "databases") == true) goto L5;
            return r101;
        L5:
            return new PolarisFileWrapper("/data/system");
        }

        private final String buildDbPath(Context r100, String r101) {
            StringBuilder r102 = new StringBuilder();
            com.larus.im.internal.delegate.c r103 = com.larus.im.internal.delegate.c.f348197a;
            Object r104 = r103.i();
            if (r104 != null) goto L5;
            r104 = getDatabasesDir(r103.getApplication());
        L5:
            r102.append(r104);
            r102.append(File.separator);
            r102.append(r101);
            return r102.toString();
        }
    }

    static {
        Companion = new Companion(null);
    }

    private final native boolean dropAndResetMessageFtsTableInternal(String r100);

    private final native BotDao getBotDAO(String r100);

    private final native ConversationDao getConversationDAO(String r100);

    private final native DBIndexDAO getIndexDAO(String r100);

    private final native MessageDao getMessageDAO(String r100);

    private final native ParticipantDao getParticipantDAO(String r100);

    private final native int releaseDbInternal(String r100, boolean r101);

    public final boolean dropMessageFtsTable() {
        return dropAndResetMessageFtsTableInternal(this.path);
    }

    public final BotDao getBotDAO() {
        return getBotDAO(this.path);
    }

    public final ConversationDao getConversationDAO() {
        return getConversationDAO(this.path);
    }

    public final DBIndexDAO getIndexDAO() {
        return getIndexDAO(this.path);
    }

    public final MessageDao getMessageDAO() {
        return getMessageDAO(this.path);
    }

    public final ParticipantDao getParticipantDAO() {
        return getParticipantDAO(this.path);
    }

    public final String getPath() {
        return this.path;
    }

    public OmniCppHelper(String r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        this.path = r100;
        com.larus.im.internal.delegate.a.f348188b.i(TAG, "init omni db success, dbPath: " + r100);
    }

    public final void releaseDb(boolean r100) {
        releaseDbInternal(this.path, r100);
    }
}
