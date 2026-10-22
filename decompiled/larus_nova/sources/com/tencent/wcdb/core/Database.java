package com.tencent.wcdb.core;

import androidx.camera.video.AudioStats;
import com.tencent.wcdb.base.CppObject;
import com.tencent.wcdb.base.Value;
import com.tencent.wcdb.base.WCDBException;
import com.tencent.wcdb.orm.Field;
import com.tencent.wcdb.winq.Expression;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import r27.a;

/* JADX INFO: loaded from: classes35.dex */
public class Database extends HandleORMOperation {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final long DictDefaultMatchValue = Long.MAX_VALUE;
    public static String OperationInfoKeyHandleCount;
    public static String OperationInfoKeyIndexCount;
    public static String OperationInfoKeyOpenCPUTime;
    public static String OperationInfoKeyOpenTime;
    public static String OperationInfoKeySchemaUsage;
    public static String OperationInfoKeyTableCount;
    public static String OperationInfoKeyTriggerCount;
    public final String dbPath;

    /* JADX INFO: renamed from: com.tencent.wcdb.core.Database$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$tencent$wcdb$core$Database$ConfigPriority = null;

        static {
            int[] r100 = new int[ConfigPriority.values().length];
            $SwitchMap$com$tencent$wcdb$core$Database$ConfigPriority = r100;
            r100[ConfigPriority.low.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$com$tencent$wcdb$core$Database$ConfigPriority[ConfigPriority.high.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$tencent$wcdb$core$Database$ConfigPriority[ConfigPriority.highest.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public interface BackupFilter {
        boolean tableShouldBeBackup(String r100);
    }

    public interface BusyTracer {
        void onTrace(long r100, String r101, long r102, String r103);
    }

    public static final enum CipherVersion extends Enum<CipherVersion> {
        private static final /* synthetic */ CipherVersion[] $VALUES = null;
        public static final CipherVersion defaultVersion = null;
        public static final CipherVersion version1 = null;
        public static final CipherVersion version2 = null;
        public static final CipherVersion version3 = null;
        public static final CipherVersion version4 = null;

        private static /* synthetic */ CipherVersion[] $values() {
            return new CipherVersion[]{defaultVersion, version1, version2, version3, version4};
        }

        static {
            defaultVersion = new CipherVersion("defaultVersion", 0);
            version1 = new CipherVersion("version1", 1);
            version2 = new CipherVersion("version2", 2);
            version3 = new CipherVersion("version3", 3);
            version4 = new CipherVersion("version4", 4);
            $VALUES = $values();
        }

        public static CipherVersion[] values() {
            return (CipherVersion[]) $VALUES.clone();
        }

        public static CipherVersion valueOf(String r100) {
            return (CipherVersion) a.a(CipherVersion.class, r100);
        }

        private CipherVersion(String r100, int r101) {
            super(r100, r101);
        }
    }

    public interface CloseCallBack {
        void onClose() throws WCDBException;
    }

    public interface CompressionFilter {
        void filterCompress(CompressionInfo r100);
    }

    public static class CompressionInfo {
        private long cppInfo;
        public String table;

        public <T> void enableReplaceCompression() {
            Database.access$200(this.cppInfo);
        }

        public <T> void addZSTDNormalCompress(Field<T> r100) {
            Database.access$000(this.cppInfo, CppObject.get(r100));
        }

        public CompressionInfo(long r100, String r101) {
            this.cppInfo = r100;
            this.table = r101;
        }

        public <T> void addZSTDDictCompress(Field<T> r100, byte r101) {
            Database.access$100(this.cppInfo, CppObject.get(r100), r101);
        }

        public <T> void addZSTDMultiDictCompress(Field<T> r110, Field<T> r111, Map<Long, Byte> r112) {
            long[] r100 = new long[r112.size()];
            byte[] r101 = new byte[r112.size()];
            Iterator<Map.Entry<Long, Byte>> r113 = r112.entrySet().iterator();
            int r102 = 0;
        L4:
            if (r113.hasNext() == false) goto L6;
            Map.Entry<Long, Byte> r103 = r113.next();
            r100[r102] = r103.getKey().longValue();
            r101[r102] = r103.getValue().byteValue();
            r102 = r102 + 1;
            goto L4
        L6:
            Database.access$300(this.cppInfo, CppObject.get(r110), CppObject.get(r111), r100, r101);
        }
    }

    public interface CompressionNotification {
        void onCompressed(Database r100, String r101);
    }

    public interface Config {
        void onInvocation(Handle r100) throws WCDBException;
    }

    public static final enum ConfigPriority extends Enum<ConfigPriority> {
        private static final /* synthetic */ ConfigPriority[] $VALUES = null;
        public static final ConfigPriority default_ = null;
        public static final ConfigPriority high = null;
        public static final ConfigPriority highest = null;
        public static final ConfigPriority low = null;

        private static /* synthetic */ ConfigPriority[] $values() {
            return new ConfigPriority[]{low, default_, high, highest};
        }

        static {
            low = new ConfigPriority("low", 0);
            default_ = new ConfigPriority("default_", 1);
            high = new ConfigPriority("high", 2);
            highest = new ConfigPriority("highest", 3);
            $VALUES = $values();
        }

        public static ConfigPriority[] values() {
            return (ConfigPriority[]) $VALUES.clone();
        }

        public static ConfigPriority valueOf(String r100) {
            return (ConfigPriority) a.a(ConfigPriority.class, r100);
        }

        private ConfigPriority(String r100, int r101) {
            super(r100, r101);
        }
    }

    public interface CorruptionNotification {
        void onCorrupted(Database r100);
    }

    public interface ExceptionTracer {
        void onTrace(WCDBException r100);
    }

    public interface MigrationFilter {
        void filterMigrate(MigrationInfo r100);
    }

    public static class MigrationInfo {
        public Expression filterCondition;
        public String sourceTable;
        public String table;

        public MigrationInfo() {
        }
    }

    public interface MigrationNotification {
        void onMigrated(Database r100, MigrationInfo r101);
    }

    public static final enum Operation extends Enum<Operation> {
        private static final /* synthetic */ Operation[] $VALUES = null;
        public static final Operation Create = null;
        public static final Operation OpenHandle = null;
        public static final Operation SetTag = null;

        private static /* synthetic */ Operation[] $values() {
            return new Operation[]{Create, SetTag, OpenHandle};
        }

        static {
            Create = new Operation("Create", 0);
            SetTag = new Operation("SetTag", 1);
            OpenHandle = new Operation("OpenHandle", 2);
            $VALUES = $values();
        }

        public static Operation[] values() {
            return (Operation[]) $VALUES.clone();
        }

        public static Operation valueOf(String r100) {
            return (Operation) a.a(Operation.class, r100);
        }

        private Operation(String r100, int r101) {
            super(r100, r101);
        }
    }

    public interface OperationTracer {
        void onTrace(Database r100, Operation r101, HashMap<String, Value> r102);
    }

    public static class PerformanceInfo {
        public long costInNanoseconds;
        public int indexPageReadCount;
        public int indexPageWriteCount;
        public int overflowPageReadCount;
        public int overflowPageWriteCount;
        public int tablePageReadCount;
        public int tablePageWriteCount;

        public PerformanceInfo() {
        }
    }

    public interface PerformanceTracer {
        void onTrace(long r100, String r101, long r102, String r103, PerformanceInfo r104);
    }

    public interface ProgressMonitor {
        boolean onProgressUpdate(double r100, double r101);
    }

    public interface SQLTracer {
        void onTrace(long r100, String r101, long r102, String r103, String r104);
    }

    private static native void addAuxiliaryFunction(long r100, String r101);

    private static native void addMigrationSource(long r100, String r101, byte[] r102, MigrationFilter r103);

    private static native void addTokenizer(long r100, String r101);

    private static native void addZSTDDictCompress(long r100, long r101, byte r102);

    private static native void addZSTDMultiDictCompress(long r100, long r101, long r102, long[] r103, byte[] r104);

    private static native void addZSTDNormalCompress(long r100, long r101);

    private static native boolean backup(long r100);

    private static native void blockade(long r100);

    private static native boolean canOpen(long r100);

    private static native boolean checkIfCorrupted(long r100);

    private static native boolean checkIfIsAlreadyCorrupted(long r100);

    private static native void close(long r100, CloseCallBack r101);

    private static native void configPinyinDict(String[] r100, String[][] r101);

    private static native void configTraditionalChineseDict(String[] r100, String[] r101);

    private static native boolean containDepositedFiles(long r100);

    private static native long createDatabase(String r100);

    private static native boolean deposit(long r100);

    private static native void disableCompressNewData(long r100, boolean r101);

    private static native void enableAutoBackup(long r100, boolean r101);

    private static native void enableAutoCompression(long r100, boolean r101);

    private static native void enableAutoMigration(long r100, boolean r101);

    private static native void enableAutoVacuum(long r100, boolean r101);

    private static native void enableLiteMode(long r100, boolean r101);

    private static native void enableReplaceCompression(long r100);

    private static native void enumerateInfo(HashMap<String, Value> r100, long r101);

    private static native void filterBackup(long r100, BackupFilter r101);

    private static native long getError(long r100);

    private static native long getFileSize(long r100);

    public static native long getHandle(long r100, boolean r101);

    private static native int getNumberOfAliveHandle(long r100);

    private static native String getPath(long r100);

    private static native List<String> getPaths(long r100);

    private static native long getTag(long r100);

    private static native long getThreadedError();

    public static native void globalTraceBusy(BusyTracer r100, double r101);

    public static native void globalTraceDatabaseOperation(OperationTracer r100);

    public static native void globalTraceException(ExceptionTracer r100);

    public static native void globalTracePerformance(PerformanceTracer r100);

    public static native void globalTraceSQL(SQLTracer r100);

    private static native boolean incrementalVacuum(long r100, int r101);

    private static native boolean isBlockaded(long r100);

    private static native boolean isCompressed(long r100);

    private static native boolean isMigrated(long r100);

    private static native boolean isOpened(long r100);

    private static native boolean moveFile(long r100, String r101);

    private static native boolean nativeRegisterDict(byte[] r100, byte r101);

    private static native boolean passiveCheckpoint(long r100);

    private static native void purge(long r100);

    public static native void purgeAll();

    public static native void releaseSQLiteMemory(int r100);

    private static native boolean removeDepositedFiles(long r100);

    private static native boolean removeFiles(long r100);

    private static native double retrieve(long r100, ProgressMonitor r101);

    private static native boolean rollbackCompression(long r100, ProgressMonitor r101);

    private static native void setAutoCheckpointEnable(long r100, boolean r101);

    public static native void setAutoCheckpointMinFrames(int r100);

    private static native void setCipherKey(long r100, byte[] r101, int r102, int r103);

    private static native void setCompression(long r100, CompressionFilter r101);

    private static native void setConfig(long r100, String r101, Config r102, Config r103, int r104);

    private static native void setDefaultCipherVersion(int r100);

    private static native void setFullSQLTraceEnable(long r100, boolean r101);

    private static native void setMigrationInfo(long r100, long r101, String r102, long r103);

    private static native void setNotificationWhenCompressed(long r100, CompressionNotification r101);

    private static native void setNotificationWhenCorrupted(long r100, CorruptionNotification r101);

    private static native void setNotificationWhenMigrated(long r100, MigrationNotification r101);

    public static native void setSoftHeapLimit(long r100);

    private static native void setTag(long r100, long r101);

    private static native boolean stepCompression(long r100);

    private static native boolean stepMigration(long r100);

    private static native void traceException(long r100, ExceptionTracer r101);

    private static native void tracePerformance(long r100, PerformanceTracer r101);

    private static native void traceSQL(long r100, SQLTracer r101);

    private static native byte[] trainDict(String[] r100, byte r101);

    private static native byte[] trainDict(byte[][] r100, byte r101);

    private static native boolean truncateCheckpoint(long r100);

    private static native void unblockade(long r100);

    private static native boolean vacuum(long r100, ProgressMonitor r101);

    @Override // com.tencent.wcdb.core.HandleOperation
    public boolean autoInvalidateHandle() {
        return true;
    }

    @Override // com.tencent.wcdb.core.HandleORMOperation
    public Database getDatabase() {
        return this;
    }

    static {
        OperationInfoKeyHandleCount = "HandleCount";
        OperationInfoKeyOpenTime = "OpenTime";
        OperationInfoKeyOpenCPUTime = "OpenCPUTime";
        OperationInfoKeySchemaUsage = "SchemaUsage";
        OperationInfoKeyTableCount = "TableCount";
        OperationInfoKeyIndexCount = "IndexCount";
        OperationInfoKeyTriggerCount = "TriggerCount";
    }

    public void backup() throws WCDBException {
        if (backup(this.cppObj) == false) goto L6;
        return;
    L6:
        throw createException();
    }

    public void blockade() {
        blockade(this.cppObj);
    }

    public boolean canOpen() {
        return canOpen(this.cppObj);
    }

    public boolean checkIfCorrupted() {
        return checkIfCorrupted(this.cppObj);
    }

    public boolean checkIfIsAlreadyCorrupted() {
        return checkIfIsAlreadyCorrupted(this.cppObj);
    }

    public void close() {
        long r100 = this.cppObj;
        this.cppObj = 0;
        if (r100 <= 0) goto L6;
        close(r100, null);
        return;
    }

    public boolean containDepositedFiles() {
        return containDepositedFiles(this.cppObj);
    }

    public WCDBException createException() {
        return WCDBException.createException(getError(this.cppObj));
    }

    public void deposit() throws WCDBException {
        if (deposit(this.cppObj) == false) goto L6;
        return;
    L6:
        throw createException();
    }

    public long getFileSize() throws WCDBException {
        long r100 = getFileSize(this.cppObj);
        if (r100 < 0) goto L6;
        return r100;
    L6:
        throw createException();
    }

    public Handle getHandle() {
        return new Handle(this, false);
    }

    public int getNumberOfAliveHandle() {
        return getNumberOfAliveHandle(this.cppObj);
    }

    public List<String> getPaths() {
        return getPaths(this.cppObj);
    }

    public long getTag() {
        return getTag(this.cppObj);
    }

    public boolean isBlockaded() {
        return isBlockaded(this.cppObj);
    }

    public boolean isCompressed() {
        return isCompressed(this.cppObj);
    }

    public boolean isMigrated() {
        return isMigrated(this.cppObj);
    }

    public boolean isOpened() {
        return isOpened(this.cppObj);
    }

    public void passiveCheckpoint() throws WCDBException {
        if (passiveCheckpoint(this.cppObj) == false) goto L6;
        return;
    L6:
        throw createException();
    }

    public void purge() {
        purge(this.cppObj);
    }

    public void removeDepositedFiles() throws WCDBException {
        if (removeDepositedFiles(this.cppObj) == false) goto L6;
        return;
    L6:
        throw createException();
    }

    public void removeFiles() throws WCDBException {
        if (removeFiles(this.cppObj) == false) goto L6;
        return;
    L6:
        throw createException();
    }

    public void stepCompression() throws WCDBException {
        if (stepCompression(this.cppObj) == false) goto L6;
        return;
    L6:
        throw createException();
    }

    public void stepMigration() throws WCDBException {
        if (stepMigration(this.cppObj) == false) goto L6;
        return;
    L6:
        throw createException();
    }

    public void truncateCheckpoint() throws WCDBException {
        if (truncateCheckpoint(this.cppObj) == false) goto L6;
        return;
    L6:
        throw createException();
    }

    public void unblockade() {
        unblockade(this.cppObj);
    }

    private Database() {
        this.dbPath = "";
    }

    private static WCDBException createThreadedException() {
        return WCDBException.createException(getThreadedError());
    }

    public String getPath() {
        return this.dbPath;
    }

    public Database(String r100) {
        this.dbPath = r100;
        this.cppObj = createDatabase(r100);
    }

    public static /* synthetic */ void access$200(long r100) {
        enableReplaceCompression(r100);
    }

    public static void configPinyinDict(Map<String, List<String>> r100) {
        String[] r101 = (String[]) r100.keySet().toArray(new String[0]);
        if (r101.length != 0) goto L5;
        return;
    L5:
        String[][] r102 = new String[r101.length][];
        int r103 = 0;
    L7:
        if (r103 >= r101.length) goto L13;
        List<String> r104 = r100.get(r101[r103]);
        if (r104 == null) goto L12;
        r102[r103] = (String[]) r104.toArray(new String[0]);
    L12:
        r103 = r103 + 1;
        goto L7
    L13:
        configPinyinDict(r101, r102);
    }

    public static void configTraditionalChineseDict(Map<String, String> r100) {
        int r101 = 0;
        String[] r102 = (String[]) r100.keySet().toArray(new String[0]);
        if (r102.length != 0) goto L5;
        return;
    L5:
        String[] r103 = new String[r102.length];
    L7:
        if (r101 >= r102.length) goto L9;
        r103[r101] = r100.get(r102[r101]);
        r101 = r101 + 1;
        goto L7
    L9:
        configTraditionalChineseDict(r102, r103);
    }

    private static void onClose(CloseCallBack r100) throws WCDBException {
        r100.onClose();
    }

    public static void setDefaultCipherVersion(CipherVersion r100) {
        setDefaultCipherVersion(r100.ordinal());
    }

    public void addAuxiliaryFunction(String r100) {
        addAuxiliaryFunction(this.cppObj, r100);
    }

    public void addTokenizer(String r100) {
        addTokenizer(this.cppObj, r100);
    }

    public void close(CloseCallBack r100) {
        long r101 = this.cppObj;
        this.cppObj = 0;
        if (r101 <= 0) goto L6;
        close(r101, r100);
        return;
    }

    public void disableCompressNewData(boolean r100) {
        disableCompressNewData(this.cppObj, r100);
    }

    public void enableAutoBackup(boolean r100) {
        enableAutoBackup(this.cppObj, r100);
    }

    public void enableAutoCompression(boolean r100) {
        enableAutoCompression(this.cppObj, r100);
    }

    public void enableAutoMigration(boolean r100) {
        enableAutoMigration(this.cppObj, r100);
    }

    public void enableAutoVacuum(boolean r100) {
        enableAutoVacuum(this.cppObj, r100);
    }

    public void enableLiteMode(boolean r100) {
        enableLiteMode(this.cppObj, r100);
    }

    public void filterBackup(BackupFilter r100) {
        filterBackup(this.cppObj, r100);
    }

    @Override // com.tencent.wcdb.core.HandleOperation
    public Handle getHandle(boolean r100) {
        return new Handle(this, r100);
    }

    public void incrementalVacuum(int r100) throws WCDBException {
        if (incrementalVacuum(this.cppObj, r100) == false) goto L6;
        return;
    L6:
        throw createException();
    }

    public void moveFile(String r100) throws WCDBException {
        if (moveFile(this.cppObj, r100) == false) goto L6;
        return;
    L6:
        throw createException();
    }

    public double retrieve(ProgressMonitor r100) throws WCDBException {
        double r101 = retrieve(this.cppObj, r100);
        if (r101 < AudioStats.AUDIO_AMPLITUDE_NONE) goto L6;
        return r101;
    L6:
        throw createException();
    }

    public void rollbackCompression(ProgressMonitor r100) throws WCDBException {
        if (rollbackCompression(this.cppObj, r100) == false) goto L6;
        return;
    L6:
        throw createException();
    }

    public void setAutoCheckpointEnable(boolean r100) {
        setAutoCheckpointEnable(this.cppObj, r100);
    }

    public void setCipherKey(byte[] r100) {
        setCipherKey(r100, 4096);
    }

    public void setCompression(CompressionFilter r100) {
        setCompression(this.cppObj, r100);
    }

    public void setFullSQLTraceEnable(boolean r100) {
        setFullSQLTraceEnable(this.cppObj, r100);
    }

    public void setNotificationWhenCompressed(CompressionNotification r100) {
        setNotificationWhenCompressed(this.cppObj, r100);
    }

    public void setNotificationWhenCorrupted(CorruptionNotification r100) {
        setNotificationWhenCorrupted(this.cppObj, r100);
    }

    public void setNotificationWhenMigrated(MigrationNotification r100) {
        setNotificationWhenMigrated(this.cppObj, r100);
    }

    public void setTag(long r100) {
        setTag(this.cppObj, r100);
    }

    public void traceException(ExceptionTracer r100) {
        traceException(this.cppObj, r100);
    }

    public void tracePerformance(PerformanceTracer r100) {
        tracePerformance(this.cppObj, r100);
    }

    public void traceSQL(SQLTracer r100) {
        traceSQL(this.cppObj, r100);
    }

    public void vacuum(ProgressMonitor r100) throws WCDBException {
        if (vacuum(this.cppObj, r100) == false) goto L6;
        return;
    L6:
        throw createException();
    }

    public static /* synthetic */ void access$000(long r100, long r101) {
        addZSTDNormalCompress(r100, r101);
    }

    private static boolean checkTableShouldBeBackup(BackupFilter r100, String r101) {
        return r100.tableShouldBeBackup(r101);
    }

    private static boolean onConfig(long r100, Config r101) {
        r101.onInvocation(new Handle(r100, null));     // Catch: WCDBException -> L5
        return true;
    L5:
        return false;
    }

    private static void onCorrupted(CorruptionNotification r100, long r101) {
        Database r102 = new Database();
        r102.cppObj = r101;
        r100.onCorrupted(r102);
    }

    private static void onTraceException(ExceptionTracer r100, long r101) {
        r100.onTrace(WCDBException.createException(r101));
    }

    public static void registerDict(byte[] r100, byte r101) throws WCDBException {
        if (nativeRegisterDict(r100, r101) == false) goto L6;
        return;
    L6:
        throw createThreadedException();
    }

    public static byte[] trainDictWithData(List<byte[]> r100, byte r101) throws WCDBException {
        byte[] r102 = trainDict((byte[][]) r100.toArray(new byte[0][]), r101);
        if (r102 == null) goto L8;
        if (r102.length == 0) goto L8;
        return r102;
    L8:
        throw createThreadedException();
    }

    public static byte[] trainDictWithString(List<String> r100, byte r101) throws WCDBException {
        byte[] r102 = trainDict((String[]) r100.toArray(new String[0]), r101);
        if (r102 == null) goto L8;
        if (r102.length == 0) goto L8;
        return r102;
    L8:
        throw createThreadedException();
    }

    public void addMigrationSource(String r100, MigrationFilter r101) {
        addMigrationSource(r100, null, r101);
    }

    public void setCipherKey(byte[] r100, int r101) {
        setCipherKey(r100, r101, CipherVersion.defaultVersion);
    }

    public void setConfig(String r100, Config r101) {
        setConfig(r100, r101, ConfigPriority.default_);
    }

    public static /* synthetic */ void access$100(long r100, long r101, byte r102) {
        addZSTDDictCompress(r100, r101, r102);
    }

    private static void filterCompress(CompressionFilter r100, long r101, String r102) {
        r100.filterCompress(new CompressionInfo(r101, r102));
    }

    private static boolean onProgressUpdate(ProgressMonitor r100, double r101, double r102) {
        return r100.onProgressUpdate(r101, r102);
    }

    private static void onTableCompressed(CompressionNotification r100, long r101, String r102) {
        Database r103 = new Database();
        r103.cppObj = r101;
        r100.onCompressed(r103, r102);
    }

    public void addMigrationSource(String r100, byte[] r101, MigrationFilter r102) {
        addMigrationSource(this.cppObj, r100, r101, r102);
    }

    public void setCipherKey(byte[] r100, int r101, CipherVersion r102) {
        setCipherKey(this.cppObj, r100, r101, r102.ordinal());
    }

    public void setConfig(String r100, Config r101, ConfigPriority r102) {
        setConfig(r100, r101, null, r102);
    }

    private static void filterMigrate(MigrationFilter r100, long r101, long r110, String r111) {
        MigrationInfo r102 = new MigrationInfo();
        r102.table = r111;
        r100.filterMigrate(r102);
        setMigrationInfo(r101, r110, r102.sourceTable, CppObject.get(r102.filterCondition));
    }

    private static void onTableMigrated(MigrationNotification r100, long r101, String r102, String r103) {
        Database r104 = new Database();
        r104.cppObj = r101;
        if (r102 != null) goto L5;
    L7:
        MigrationInfo r105 = null;
    L8:
        r100.onMigrated(r104, r105);
        return;
    L5:
        if (r102.length() <= 0) goto L7;
        r105 = new MigrationInfo();
        r105.table = r102;
        r105.sourceTable = r103;
        goto L8
    }

    private static void onTraceOperation(OperationTracer r100, long r101, int r102, long r103) {
        Database r104 = new Database();
        r104.cppObj = r101;
        Operation r105 = Operation.Create;
        if (r102 != 1) goto L5;
        r105 = Operation.SetTag;
    L9:
        HashMap<String, Value> r106 = new HashMap();
        enumerateInfo(r106, r103);
        r100.onTrace(r104, r105, r106);
        return;
    L5:
        if (r102 != 2) goto L9;
        r105 = Operation.OpenHandle;
        goto L9
    }

    public void setConfig(String r100, Config r101, Config r102, ConfigPriority r110) {
        int r111 = AnonymousClass1.$SwitchMap$com$tencent$wcdb$core$Database$ConfigPriority[r110.ordinal()];
        if (r111 != 1) goto L5;
        int r103 = 100;
    L12:
        setConfig(this.cppObj, r100, r101, r102, r103);
        return;
    L5:
        if (r111 != 2) goto L7;
        r103 = -100;
        goto L12
    L7:
        if (r111 == 3) goto L9;
        r103 = 0;
        goto L12
    L9:
        r103 = Integer.MIN_VALUE;
        goto L12
    }

    public static /* synthetic */ void access$300(long r100, long r101, long r102, long[] r103, byte[] r104) {
        addZSTDMultiDictCompress(r100, r101, r102, r103, r104);
    }

    private static void onBusyTrace(BusyTracer r100, long r101, String r102, long r103, String r104) {
        r100.onTrace(r101, r102, r103, r104);
    }

    private static void onEnumerateInfo(HashMap<String, Value> r100, String r101, int r102, long r103, double r104, String r105) {
        if (r102 != 3) goto L6;
        r100.put(r101, new Value(r103));
        return;
    L6:
        if (r102 != 5) goto L9;
        r100.put(r101, new Value(r104));
        return;
    L9:
        if (r102 != 6) goto L14;
        r100.put(r101, new Value(r105));
        return;
    }

    private static void onTraceSQL(SQLTracer r100, long r101, String r102, long r103, String r104, String r105) {
        r100.onTrace(r101, r102, r103, r104, r105);
    }

    private static void onTracePerformance(PerformanceTracer r110, long r111, String r112, long r113, String r114, long r115, int[] r116) {
        if (r116 != null) goto L5;
    L7:
        PerformanceInfo r100 = null;
    L8:
        r110.onTrace(r111, r112, r113, r114, r100);
        return;
    L5:
        if (r116.length != 6) goto L7;
        r100 = new PerformanceInfo();
        r100.tablePageReadCount = r116[0];
        r100.tablePageWriteCount = r116[1];
        r100.indexPageReadCount = r116[2];
        r100.indexPageWriteCount = r116[3];
        r100.overflowPageReadCount = r116[4];
        r100.overflowPageWriteCount = r116[5];
        r100.costInNanoseconds = r115;
        goto L8
    }
}
