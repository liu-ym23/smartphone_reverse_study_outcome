package com.bytedance.ee.docsdk.impl.document.plugins.offline.storage;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class ResourceDataDao_Impl extends ResourceDataDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<ResourceData> __insertionAdapterOfResourceData;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAllPageData;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAllPageData_1;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAllResource;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAllResource_1;
    private final SharedSQLiteStatement __preparedStmtOfDeleteResourceData;
    private final SharedSQLiteStatement __preparedStmtOfDeleteResourceDataByDocToken;
    private final SharedSQLiteStatement __preparedStmtOfDeleteResourceDataByDocToken_1;
    private final SharedSQLiteStatement __preparedStmtOfDeleteResourceData_1;
    private final EntityDeletionOrUpdateAdapter<ResourceData> __updateAdapterOfResourceData;

    @Override // com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceDataDao
    public int deleteAllPageData() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfDeleteAllPageData.acquire();
        this.__db.beginTransaction();
        int r1 = r0.executeUpdateDelete();     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        this.__preparedStmtOfDeleteAllPageData.release(r0);
        return r1;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfDeleteAllPageData.release(r0);
        throw th;
    }

    @Override // com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceDataDao
    public int deleteAllResource() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfDeleteAllResource.acquire();
        this.__db.beginTransaction();
        int r1 = r0.executeUpdateDelete();     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        this.__preparedStmtOfDeleteAllResource.release(r0);
        return r1;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfDeleteAllResource.release(r0);
        throw th;
    }

    @Override // com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceDataDao
    public List<String> getTokenList() {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT obj_token FROM ResourceData group by obj_token", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor r2 = DBUtil.query(this.__db, r0, false, null);
        ArrayList r4 = new ArrayList(r2.getCount());     // Catch: Throwable -> L14
    L4:
        if (r2.moveToNext() == false) goto L12;
        if (r2.isNull(0) == false) goto L9;
        String r5 = null;
    L10:
        r4.add(r5);     // Catch: Throwable -> L14
        goto L4
    L9:
        r5 = r2.getString(0);     // Catch: Throwable -> L14
        goto L10
    L12:
        r2.close();
        r0.release();
        return r4;
    L14:
        th = move-exception;
        r2.close();
        r0.release();
        throw th;
    }

    @Override // com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceDataDao
    public List<ResourceDataDelegate> loadAllPageResourceDelegate() {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT id, resvalue_filepath FROM ResourceData WHERE total_page > page", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor r2 = DBUtil.query(this.__db, r0, false, null);
        ArrayList r4 = new ArrayList(r2.getCount());     // Catch: Throwable -> L14
    L4:
        if (r2.moveToNext() == false) goto L12;
        ResourceDataDelegate r5 = new ResourceDataDelegate();     // Catch: Throwable -> L14
        r5.setId(r2.getInt(0));     // Catch: Throwable -> L14
        if (r2.isNull(1) == false) goto L9;
        String r6 = null;
    L10:
        r5.setResvalueFilePath(r6);     // Catch: Throwable -> L14
        r4.add(r5);     // Catch: Throwable -> L14
        goto L4
    L9:
        r6 = r2.getString(1);     // Catch: Throwable -> L14
        goto L10
    L12:
        r2.close();
        r0.release();
        return r4;
    L14:
        th = move-exception;
        r2.close();
        r0.release();
        throw th;
    }

    @Override // com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceDataDao
    public List<ResourceDataDelegate> loadDirtyPageData() {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("Select a.* from ResourceData a join (Select distinct id,reskey,obj_token from (Select id,reskey,obj_token,batch_num,total_page,max(page) as max_page from ResourceData group by reskey,obj_token,batch_num,total_page) where total_page > 1 and max_page + 1 < total_page)b\non a.reskey=b.reskey and a.obj_token=b.obj_token", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor r1 = DBUtil.query(this.__db, r0, false, null);
        int r2 = CursorUtil.getColumnIndexOrThrow(r1, ResourceData.KEY_ID);     // Catch: Throwable -> L38
        int r4 = CursorUtil.getColumnIndexOrThrow(r1, ResourceData.KEY_RES_KEY);     // Catch: Throwable -> L38
        int r5 = CursorUtil.getColumnIndexOrThrow(r1, ResourceData.KEY_RESOURCE_VALUE_FILE_PATH);     // Catch: Throwable -> L38
        int r6 = CursorUtil.getColumnIndexOrThrow(r1, ResourceData.ACCESS_TIME);     // Catch: Throwable -> L38
        int r7 = CursorUtil.getColumnIndexOrThrow(r1, ResourceData.KEY_TYPE);     // Catch: Throwable -> L38
        int r8 = CursorUtil.getColumnIndexOrThrow(r1, ResourceData.KEY_TOKEN);     // Catch: Throwable -> L38
        int r9 = CursorUtil.getColumnIndexOrThrow(r1, ResourceData.KEY_OBJ_TOKEN);     // Catch: Throwable -> L38
        int r10 = CursorUtil.getColumnIndexOrThrow(r1, ResourceData.KEY_URL);     // Catch: Throwable -> L38
        ArrayList r11 = new ArrayList(r1.getCount());     // Catch: Throwable -> L38
    L4:
        if (r1.moveToNext() == false) goto L36;
        ResourceDataDelegate r12 = new ResourceDataDelegate();     // Catch: Throwable -> L38
        r12.setId(r1.getInt(r2));     // Catch: Throwable -> L38
        if (r1.isNull(r4) == false) goto L9;
        String r13 = null;
    L10:
        r12.setReskey(r13);     // Catch: Throwable -> L38
        if (r1.isNull(r5) == false) goto L13;
        String r14 = null;
    L14:
        r12.setResvalueFilePath(r14);     // Catch: Throwable -> L38
        if (r1.isNull(r6) == false) goto L17;
        Long r15 = null;
    L18:
        r12.setAccessTime(r15);     // Catch: Throwable -> L38
        if (r1.isNull(r7) == false) goto L21;
        String r16 = null;
    L22:
        r12.setType(r16);     // Catch: Throwable -> L38
        if (r1.isNull(r8) == false) goto L25;
        String r17 = null;
    L26:
        r12.setToken(r17);     // Catch: Throwable -> L38
        if (r1.isNull(r9) == false) goto L29;
        String r18 = null;
    L30:
        r12.setObj_token(r18);     // Catch: Throwable -> L38
        if (r1.isNull(r10) == false) goto L33;
        String r19 = null;
    L34:
        r12.setUrl(r19);     // Catch: Throwable -> L38
        r11.add(r12);     // Catch: Throwable -> L38
        goto L4
    L33:
        r19 = r1.getString(r10);     // Catch: Throwable -> L38
        goto L34
    L29:
        r18 = r1.getString(r9);     // Catch: Throwable -> L38
        goto L30
    L25:
        r17 = r1.getString(r8);     // Catch: Throwable -> L38
        goto L26
    L21:
        r16 = r1.getString(r7);     // Catch: Throwable -> L38
        goto L22
    L17:
        r15 = Long.valueOf(r1.getLong(r6));     // Catch: Throwable -> L38
        goto L18
    L13:
        r14 = r1.getString(r5);     // Catch: Throwable -> L38
        goto L14
    L9:
        r13 = r1.getString(r4);     // Catch: Throwable -> L38
        goto L10
    L36:
        r1.close();
        r0.release();
        return r11;
    L38:
        th = move-exception;
        r1.close();
        r0.release();
        throw th;
    }

    @Override // com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceDataDao
    public LiveData<List<String>> loadUnSyncDocuments() {
        final RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT DISTINCT obj_token FROM ResourceData WHERE isNeedSync= 1", 0);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{ResourceData.TABLE_NAME}, false, new AnonymousClass11(this, r0));
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    public ResourceDataDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfResourceData = new AnonymousClass1(this, r2);
        this.__updateAdapterOfResourceData = new AnonymousClass2(this, r2);
        this.__preparedStmtOfDeleteResourceDataByDocToken = new AnonymousClass3(this, r2);
        this.__preparedStmtOfDeleteResourceDataByDocToken_1 = new AnonymousClass4(this, r2);
        this.__preparedStmtOfDeleteResourceData = new AnonymousClass5(this, r2);
        this.__preparedStmtOfDeleteResourceData_1 = new AnonymousClass6(this, r2);
        this.__preparedStmtOfDeleteAllPageData = new AnonymousClass7(this, r2);
        this.__preparedStmtOfDeleteAllPageData_1 = new AnonymousClass8(this, r2);
        this.__preparedStmtOfDeleteAllResource = new AnonymousClass9(this, r2);
        this.__preparedStmtOfDeleteAllResource_1 = new AnonymousClass10(this, r2);
    }

    public static /* synthetic */ RoomDatabase access$000(ResourceDataDao_Impl r0) {
        return r0.__db;
    }

    @Override // com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceDataDao
    public int deleteAllPageData(long r3) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfDeleteAllPageData_1.acquire();
        r0.bindLong(1, r3);
        this.__db.beginTransaction();
        int r4 = r0.executeUpdateDelete();     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        this.__preparedStmtOfDeleteAllPageData_1.release(r0);
        return r4;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfDeleteAllPageData_1.release(r0);
        throw th;
    }

    @Override // com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceDataDao
    public int deleteAllResource(long r3) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfDeleteAllResource_1.acquire();
        r0.bindLong(1, r3);
        this.__db.beginTransaction();
        int r4 = r0.executeUpdateDelete();     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        this.__preparedStmtOfDeleteAllResource_1.release(r0);
        return r4;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfDeleteAllResource_1.release(r0);
        throw th;
    }

    @Override // com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceDataDao
    public int deleteResourceDataByDocToken(String r3) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfDeleteResourceDataByDocToken.acquire();
        if (r3 != null) goto L5;
        r0.bindNull(1);
    L6:
        this.__db.beginTransaction();
        int r4 = r0.executeUpdateDelete();     // Catch: Throwable -> L10
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L10
        this.__db.endTransaction();
        this.__preparedStmtOfDeleteResourceDataByDocToken.release(r0);
        return r4;
    L10:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfDeleteResourceDataByDocToken.release(r0);
        throw th;
    L5:
        r0.bindString(1, r3);
        goto L6
    }

    @Override // com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceDataDao
    public int deleteResourceDataByTokens(List<String> r4) {
        this.__db.assertNotSuspendingTransaction();
        StringBuilder r0 = StringUtil.newStringBuilder();
        r0.append("DELETE FROM ResourceData WHERE obj_token IN(");
        StringUtil.appendPlaceholders(r0, r4.size());
        r0.append(")");
        String r1 = r0.toString();
        SupportSQLiteStatement r2 = this.__db.compileStatement(r1);
        Iterator<String> r5 = r4.iterator();
        int r3 = 1;
    L4:
        if (r5.hasNext() == false) goto L10;
        String r6 = r5.next();
        if (r6 != null) goto L8;
        r2.bindNull(r3);
    L9:
        r3 = r3 + 1;
        goto L4
    L8:
        r2.bindString(r3, r6);
        goto L9
    L10:
        this.__db.beginTransaction();
        int r7 = r2.executeUpdateDelete();     // Catch: Throwable -> L14
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L14
        this.__db.endTransaction();
        return r7;
    L14:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceDataDao
    public long insertResourceData(ResourceData r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfResourceData.insertAndReturnId(r3);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r0;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceDataDao
    public List<ResourceDataDelegate> loadAllPageResourceDelegate(long r7) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT id, resvalue_filepath FROM ResourceData WHERE total_page > page AND (category IS NULL OR (category IS NOT NULL AND access_time<= ?))", 1);
        r0.bindLong(1, r7);
        this.__db.assertNotSuspendingTransaction();
        Cursor r8 = DBUtil.query(this.__db, r0, false, null);
        ArrayList r3 = new ArrayList(r8.getCount());     // Catch: Throwable -> L14
    L4:
        if (r8.moveToNext() == false) goto L12;
        ResourceDataDelegate r4 = new ResourceDataDelegate();     // Catch: Throwable -> L14
        r4.setId(r8.getInt(0));     // Catch: Throwable -> L14
        if (r8.isNull(1) == false) goto L9;
        String r5 = null;
    L10:
        r4.setResvalueFilePath(r5);     // Catch: Throwable -> L14
        r3.add(r4);     // Catch: Throwable -> L14
        goto L4
    L9:
        r5 = r8.getString(1);     // Catch: Throwable -> L14
        goto L10
    L12:
        r8.close();
        r0.release();
        return r3;
    L14:
        th = move-exception;
        r8.close();
        r0.release();
        throw th;
    }

    @Override // com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceDataDao
    public LiveData<List<String>> loadCacheDocumentTokens(int r5) {
        final RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT DISTINCT obj_token FROM ResourceData WHERE reskey LIKE '%CLIENT_VARS%' order by update_time desc limit ?", 1);
        r0.bindLong(1, r5);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{ResourceData.TABLE_NAME}, false, new AnonymousClass12(this, r0));
    }

    @Override // com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceDataDao
    public List<ResourceDataDelegate> loadResDataInDiskCache(int r8) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT obj_token,resvalue_filepath,id FROM ResourceData WHERE resvalue_filepath NOT NULL limit ?", 1);
        r0.bindLong(1, r8);
        this.__db.assertNotSuspendingTransaction();
        Cursor r9 = DBUtil.query(this.__db, r0, false, null);
        ArrayList r4 = new ArrayList(r9.getCount());     // Catch: Throwable -> L18
    L4:
        if (r9.moveToNext() == false) goto L16;
        ResourceDataDelegate r5 = new ResourceDataDelegate();     // Catch: Throwable -> L18
        if (r9.isNull(0) == false) goto L9;
        String r6 = null;
    L10:
        r5.setObj_token(r6);     // Catch: Throwable -> L18
        if (r9.isNull(1) == false) goto L13;
        String r7 = null;
    L14:
        r5.setResvalueFilePath(r7);     // Catch: Throwable -> L18
        r5.setId(r9.getInt(2));     // Catch: Throwable -> L18
        r4.add(r5);     // Catch: Throwable -> L18
        goto L4
    L13:
        r7 = r9.getString(1);     // Catch: Throwable -> L18
        goto L14
    L9:
        r6 = r9.getString(0);     // Catch: Throwable -> L18
        goto L10
    L16:
        r9.close();
        r0.release();
        return r4;
    L18:
        th = move-exception;
        r9.close();
        r0.release();
        throw th;
    }

    @Override // com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceDataDao
    public List<Integer> loadResIdsByObjToken(String r6) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT DISTINCT id FROM ResourceData WHERE obj_token= ?", 1);
        if (r6 != null) goto L5;
        r0.bindNull(1);
    L6:
        this.__db.assertNotSuspendingTransaction();
        Cursor r7 = DBUtil.query(this.__db, r0, false, null);
        ArrayList r3 = new ArrayList(r7.getCount());     // Catch: Throwable -> L18
    L8:
        if (r7.moveToNext() == false) goto L16;
        if (r7.isNull(0) == false) goto L13;
        Integer r4 = null;
    L14:
        r3.add(r4);     // Catch: Throwable -> L18
        goto L8
    L13:
        r4 = Integer.valueOf(r7.getInt(0));     // Catch: Throwable -> L18
        goto L14
    L16:
        r7.close();
        r0.release();
        return r3;
    L18:
        th = move-exception;
        r7.close();
        r0.release();
        throw th;
    L5:
        r0.bindString(1, r6);
        goto L6
    }

    @Override // com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceDataDao
    public List<ResourceDataDelegate> loadResourceDataByDocToken(String r8) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT resvalue_filepath,id FROM ResourceData WHERE obj_token= ?", 1);
        if (r8 != null) goto L5;
        r0.bindNull(1);
    L6:
        this.__db.assertNotSuspendingTransaction();
        Cursor r9 = DBUtil.query(this.__db, r0, false, null);
        ArrayList r4 = new ArrayList(r9.getCount());     // Catch: Throwable -> L18
    L8:
        if (r9.moveToNext() == false) goto L16;
        ResourceDataDelegate r5 = new ResourceDataDelegate();     // Catch: Throwable -> L18
        if (r9.isNull(0) == false) goto L13;
        String r6 = null;
    L14:
        r5.setResvalueFilePath(r6);     // Catch: Throwable -> L18
        r5.setId(r9.getInt(1));     // Catch: Throwable -> L18
        r4.add(r5);     // Catch: Throwable -> L18
        goto L8
    L13:
        r6 = r9.getString(0);     // Catch: Throwable -> L18
        goto L14
    L16:
        r9.close();
        r0.release();
        return r4;
    L18:
        th = move-exception;
        r9.close();
        r0.release();
        throw th;
    L5:
        r0.bindString(1, r8);
        goto L6
    }

    @Override // com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceDataDao
    public List<ResourceDataDelegate> loadResourceDataByNeedSync(boolean r9) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT DISTINCT obj_token,type,url,id FROM ResourceData WHERE isNeedSync= ?", 1);
        r0.bindLong(1, r9 ? 1 : 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor r10 = DBUtil.query(this.__db, r0, false, null);
        ArrayList r4 = new ArrayList(r10.getCount());     // Catch: Throwable -> L22
    L4:
        if (r10.moveToNext() == false) goto L20;
        ResourceDataDelegate r5 = new ResourceDataDelegate();     // Catch: Throwable -> L22
        if (r10.isNull(0) == false) goto L9;
        String r6 = null;
    L10:
        r5.setObj_token(r6);     // Catch: Throwable -> L22
        if (r10.isNull(1) == false) goto L13;
        String r7 = null;
    L14:
        r5.setType(r7);     // Catch: Throwable -> L22
        if (r10.isNull(2) == false) goto L17;
        String r8 = null;
    L18:
        r5.setUrl(r8);     // Catch: Throwable -> L22
        r5.setId(r10.getInt(3));     // Catch: Throwable -> L22
        r4.add(r5);     // Catch: Throwable -> L22
        goto L4
    L17:
        r8 = r10.getString(2);     // Catch: Throwable -> L22
        goto L18
    L13:
        r7 = r10.getString(1);     // Catch: Throwable -> L22
        goto L14
    L9:
        r6 = r10.getString(0);     // Catch: Throwable -> L22
        goto L10
    L20:
        r10.close();
        r0.release();
        return r4;
    L22:
        th = move-exception;
        r10.close();
        r0.release();
        throw th;
    }

    @Override // com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceDataDao
    public List<String> loadTokensBySync(boolean r6) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT DISTINCT obj_token FROM ResourceData WHERE isNeedSync= ?", 1);
        r0.bindLong(1, r6 ? 1 : 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor r7 = DBUtil.query(this.__db, r0, false, null);
        ArrayList r3 = new ArrayList(r7.getCount());     // Catch: Throwable -> L14
    L4:
        if (r7.moveToNext() == false) goto L12;
        if (r7.isNull(0) == false) goto L9;
        String r4 = null;
    L10:
        r3.add(r4);     // Catch: Throwable -> L14
        goto L4
    L9:
        r4 = r7.getString(0);     // Catch: Throwable -> L14
        goto L10
    L12:
        r7.close();
        r0.release();
        return r3;
    L14:
        th = move-exception;
        r7.close();
        r0.release();
        throw th;
    }

    @Override // com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceDataDao
    public int updateResourceData(ResourceData r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfResourceData.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceDataDao
    public int deleteResourceData(String r3, String r4) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfDeleteResourceData.acquire();
        if (r3 != null) goto L5;
        r0.bindNull(1);
    L7:
        if (r4 != null) goto L9;
        r0.bindNull(2);
    L10:
        this.__db.beginTransaction();
        int r5 = r0.executeUpdateDelete();     // Catch: Throwable -> L14
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L14
        this.__db.endTransaction();
        this.__preparedStmtOfDeleteResourceData.release(r0);
        return r5;
    L14:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfDeleteResourceData.release(r0);
        throw th;
    L9:
        r0.bindString(2, r4);
        goto L10
    L5:
        r0.bindString(1, r3);
        goto L7
    }

    @Override // com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceDataDao
    public int deleteResourceDataByDocToken(String r3, long r4) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfDeleteResourceDataByDocToken_1.acquire();
        if (r3 != null) goto L5;
        r0.bindNull(1);
    L6:
        r0.bindLong(2, r4);
        this.__db.beginTransaction();
        int r5 = r0.executeUpdateDelete();     // Catch: Throwable -> L10
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L10
        this.__db.endTransaction();
        this.__preparedStmtOfDeleteResourceDataByDocToken_1.release(r0);
        return r5;
    L10:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfDeleteResourceDataByDocToken_1.release(r0);
        throw th;
    L5:
        r0.bindString(1, r3);
        goto L6
    }

    @Override // com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceDataDao
    public int deleteResourceDataByTokens(List<String> r6, long r7) {
        this.__db.assertNotSuspendingTransaction();
        StringBuilder r0 = StringUtil.newStringBuilder();
        r0.append("DELETE FROM ResourceData WHERE obj_token IN(");
        int r1 = r6.size();
        StringUtil.appendPlaceholders(r0, r1);
        r0.append(") AND (category IS NULL OR (category IS NOT NULL AND access_time<= ");
        r0.append("?");
        r0.append("))");
        String r2 = r0.toString();
        SupportSQLiteStatement r3 = this.__db.compileStatement(r2);
        Iterator<String> r8 = r6.iterator();
        int r4 = 1;
    L4:
        if (r8.hasNext() == false) goto L10;
        String r5 = r8.next();
        if (r5 != null) goto L8;
        r3.bindNull(r4);
    L9:
        r4 = r4 + 1;
        goto L4
    L8:
        r3.bindString(r4, r5);
        goto L9
    L10:
        r3.bindLong(r1 + 1, r7);
        this.__db.beginTransaction();
        int r9 = r3.executeUpdateDelete();     // Catch: Throwable -> L14
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L14
        this.__db.endTransaction();
        return r9;
    L14:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceDataDao
    public List<String> loadCachedTokensBykey(List<String> r5, String r6) {
        StringBuilder r0 = StringUtil.newStringBuilder();
        r0.append("SELECT distinct obj_token FROM ResourceData WHERE obj_token IN (");
        int r1 = r5.size();
        StringUtil.appendPlaceholders(r0, r1);
        r0.append(") AND reskey = ");
        r0.append("?");
        int r2 = 1;
        int r3 = r1 + 1;
        RoomSQLiteQuery r4 = RoomSQLiteQuery.acquire(r0.toString(), r3);
        Iterator<String> r7 = r5.iterator();
    L4:
        if (r7.hasNext() == false) goto L10;
        String r8 = r7.next();
        if (r8 != null) goto L8;
        r4.bindNull(r2);
    L9:
        r2 = r2 + 1;
        goto L4
    L8:
        r4.bindString(r2, r8);
        goto L9
    L10:
        if (r6 != null) goto L12;
        r4.bindNull(r3);
    L13:
        this.__db.assertNotSuspendingTransaction();
        Cursor r9 = DBUtil.query(this.__db, r4, false, null);
        ArrayList r10 = new ArrayList(r9.getCount());     // Catch: Throwable -> L25
    L15:
        if (r9.moveToNext() == false) goto L23;
        if (r9.isNull(0) == false) goto L20;
        String r11 = null;
    L21:
        r10.add(r11);     // Catch: Throwable -> L25
        goto L15
    L20:
        r11 = r9.getString(0);     // Catch: Throwable -> L25
        goto L21
    L23:
        r9.close();
        r4.release();
        return r10;
    L25:
        th = move-exception;
        r9.close();
        r4.release();
        throw th;
    L12:
        r4.bindString(r3, r6);
        goto L13
    }

    @Override // com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceDataDao
    public List<ResourceDataDelegate> loadDeleteResourceDataByUpdateTime(List<String> r8, int r9) {
        StringBuilder r0 = StringUtil.newStringBuilder();
        r0.append("SELECT resvalue_filepath,obj_token,id,access_time FROM ResourceData WHERE obj_token NOT IN(");
        int r1 = r8.size();
        StringUtil.appendPlaceholders(r0, r1);
        r0.append(") AND reskey LIKE '%CLIENT_VARS%' order by update_time asc limit ");
        r0.append("?");
        int r2 = r1 + 1;
        RoomSQLiteQuery r3 = RoomSQLiteQuery.acquire(r0.toString(), r2);
        Iterator<String> r10 = r8.iterator();
        int r4 = 1;
    L4:
        if (r10.hasNext() == false) goto L10;
        String r5 = r10.next();
        if (r5 != null) goto L8;
        r3.bindNull(r4);
    L9:
        r4 = r4 + 1;
        goto L4
    L8:
        r3.bindString(r4, r5);
        goto L9
    L10:
        r3.bindLong(r2, r9);
        this.__db.assertNotSuspendingTransaction();
        Cursor r11 = DBUtil.query(this.__db, r3, false, null);
        ArrayList r6 = new ArrayList(r11.getCount());     // Catch: Throwable -> L30
    L12:
        if (r11.moveToNext() == false) goto L28;
        ResourceDataDelegate r7 = new ResourceDataDelegate();     // Catch: Throwable -> L30
        if (r11.isNull(0) == false) goto L17;
        String r12 = null;
    L18:
        r7.setResvalueFilePath(r12);     // Catch: Throwable -> L30
        if (r11.isNull(1) == false) goto L21;
        String r13 = null;
    L22:
        r7.setObj_token(r13);     // Catch: Throwable -> L30
        r7.setId(r11.getInt(2));     // Catch: Throwable -> L30
        if (r11.isNull(3) == false) goto L25;
        Long r14 = null;
    L26:
        r7.setAccessTime(r14);     // Catch: Throwable -> L30
        r6.add(r7);     // Catch: Throwable -> L30
        goto L12
    L25:
        r14 = Long.valueOf(r11.getLong(3));     // Catch: Throwable -> L30
        goto L26
    L21:
        r13 = r11.getString(1);     // Catch: Throwable -> L30
        goto L22
    L17:
        r12 = r11.getString(0);     // Catch: Throwable -> L30
        goto L18
    L28:
        r11.close();
        r3.release();
        return r6;
    L30:
        th = move-exception;
        r11.close();
        r3.release();
        throw th;
    }

    @Override // com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceDataDao
    public List<ResourceDataDelegate> loadReourceDelegate(String r7, String r8) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT id, resvalue_filepath FROM ResourceData WHERE obj_token=? and reskey= ?", 2);
        if (r7 != null) goto L5;
        r0.bindNull(1);
    L6:
        if (r8 != null) goto L8;
        r0.bindNull(2);
    L9:
        this.__db.assertNotSuspendingTransaction();
        Cursor r9 = DBUtil.query(this.__db, r0, false, null);
        ArrayList r3 = new ArrayList(r9.getCount());     // Catch: Throwable -> L21
    L11:
        if (r9.moveToNext() == false) goto L19;
        ResourceDataDelegate r4 = new ResourceDataDelegate();     // Catch: Throwable -> L21
        r4.setId(r9.getInt(0));     // Catch: Throwable -> L21
        if (r9.isNull(1) == false) goto L16;
        String r5 = null;
    L17:
        r4.setResvalueFilePath(r5);     // Catch: Throwable -> L21
        r3.add(r4);     // Catch: Throwable -> L21
        goto L11
    L16:
        r5 = r9.getString(1);     // Catch: Throwable -> L21
        goto L17
    L19:
        r9.close();
        r0.release();
        return r3;
    L21:
        th = move-exception;
        r9.close();
        r0.release();
        throw th;
    L8:
        r0.bindString(2, r8);
        goto L9
    L5:
        r0.bindString(1, r7);
        goto L6
    }

    @Override // com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceDataDao
    public List<ResourceDataDelegate> loadResourceDataByDocToken(String r6, long r7) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT resvalue_filepath,id FROM ResourceData WHERE obj_token= ? AND (category IS NULL OR (category IS NOT NULL AND access_time<= ?))", 2);
        if (r6 != null) goto L5;
        r0.bindNull(1);
    L6:
        r0.bindLong(2, r7);
        this.__db.assertNotSuspendingTransaction();
        Cursor r8 = DBUtil.query(this.__db, r0, false, null);
        ArrayList r1 = new ArrayList(r8.getCount());     // Catch: Throwable -> L18
    L8:
        if (r8.moveToNext() == false) goto L16;
        ResourceDataDelegate r3 = new ResourceDataDelegate();     // Catch: Throwable -> L18
        if (r8.isNull(0) == false) goto L13;
        String r4 = null;
    L14:
        r3.setResvalueFilePath(r4);     // Catch: Throwable -> L18
        r3.setId(r8.getInt(1));     // Catch: Throwable -> L18
        r1.add(r3);     // Catch: Throwable -> L18
        goto L8
    L13:
        r4 = r8.getString(0);     // Catch: Throwable -> L18
        goto L14
    L16:
        r8.close();
        r0.release();
        return r1;
    L18:
        th = move-exception;
        r8.close();
        r0.release();
        throw th;
    L5:
        r0.bindString(1, r6);
        goto L6
    }

    @Override // com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceDataDao
    public ResourceData loadResourceDataBySync(String r24, boolean r25) {
        RoomSQLiteQuery r2 = RoomSQLiteQuery.acquire("SELECT * FROM ResourceData WHERE isNeedSync= ? and obj_token= ?", 2);
        r2.bindLong(1, r25 ? 1 : 0);
        if (r24 != null) goto L5;
        r2.bindNull(2);
    L6:
        this.__db.assertNotSuspendingTransaction();
        Cursor r5 = DBUtil.query(this.__db, r2, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r5, ResourceData.KEY_ID);     // Catch: Throwable -> L82
        int r7 = CursorUtil.getColumnIndexOrThrow(r5, ResourceData.KEY_RES_KEY);     // Catch: Throwable -> L82
        int r8 = CursorUtil.getColumnIndexOrThrow(r5, ResourceData.KEY_RESOURCE_VALUE);     // Catch: Throwable -> L82
        int r9 = CursorUtil.getColumnIndexOrThrow(r5, ResourceData.KEY_RESOURCE_VALUE_FILE_PATH);     // Catch: Throwable -> L82
        int r10 = CursorUtil.getColumnIndexOrThrow(r5, "update_time");     // Catch: Throwable -> L82
        int r11 = CursorUtil.getColumnIndexOrThrow(r5, ResourceData.ACCESS_TIME);     // Catch: Throwable -> L82
        int r12 = CursorUtil.getColumnIndexOrThrow(r5, "isNeedSync");     // Catch: Throwable -> L82
        int r13 = CursorUtil.getColumnIndexOrThrow(r5, "config");     // Catch: Throwable -> L82
        int r14 = CursorUtil.getColumnIndexOrThrow(r5, ResourceData.KEY_TYPE);     // Catch: Throwable -> L82
        int r15 = CursorUtil.getColumnIndexOrThrow(r5, ResourceData.KEY_TOKEN);     // Catch: Throwable -> L82
        int r3 = CursorUtil.getColumnIndexOrThrow(r5, ResourceData.KEY_OBJ_TOKEN);     // Catch: Throwable -> L82
        int r4 = CursorUtil.getColumnIndexOrThrow(r5, "userToken");     // Catch: Throwable -> L82
        int r6 = CursorUtil.getColumnIndexOrThrow(r5, "tenantID");     // Catch: Throwable -> L82
        int r1 = CursorUtil.getColumnIndexOrThrow(r5, ResourceData.KEY_URL);     // Catch: Throwable -> L82
        RoomSQLiteQuery r16 = r2;
        int r17 = CursorUtil.getColumnIndexOrThrow(r5, ResourceData.KEY_SUBBLOCK_PRELOAD_STATUS);     // Catch: Throwable -> L80
        int r18 = CursorUtil.getColumnIndexOrThrow(r5, ResourceData.KEY_PAGE);     // Catch: Throwable -> L80
        int r19 = CursorUtil.getColumnIndexOrThrow(r5, ResourceData.KEY_TOTAL_PAGE);     // Catch: Throwable -> L80
        int r20 = CursorUtil.getColumnIndexOrThrow(r5, ResourceData.KEY_BATCH_NUM);     // Catch: Throwable -> L80
        int r21 = CursorUtil.getColumnIndexOrThrow(r5, ResourceData.KEY_LOAD_FROM);     // Catch: Throwable -> L80
        int r22 = CursorUtil.getColumnIndexOrThrow(r5, ResourceData.KEY_CATEGORY);     // Catch: Throwable -> L80
        if (r5.moveToFirst() == false) goto L77;
        ResourceData r23 = new ResourceData();     // Catch: Throwable -> L80
        r23.setId(r5.getInt(r0));     // Catch: Throwable -> L80
        if (r5.isNull(r7) == false) goto L14;
        String r26 = null;
    L15:
        r23.setReskey(r26);     // Catch: Throwable -> L80
        if (r5.isNull(r8) == false) goto L18;
        String r27 = null;
    L19:
        r23.setResvalue(r27);     // Catch: Throwable -> L80
        if (r5.isNull(r9) == false) goto L22;
        String r28 = null;
    L23:
        r23.setResvalueFilePath(r28);     // Catch: Throwable -> L80
        if (r5.isNull(r10) == false) goto L26;
        Long r29 = null;
    L27:
        r23.setUpdate_time(r29);     // Catch: Throwable -> L80
        if (r5.isNull(r11) == false) goto L30;
        Long r30 = null;
    L31:
        r23.setAccess_time(r30);     // Catch: Throwable -> L80
        if (r5.getInt(r12) == 0) goto L34;
        boolean r31 = true;
    L35:
        r23.setNeedSync(r31);     // Catch: Throwable -> L80
        if (r5.isNull(r13) == false) goto L38;
        String r32 = null;
    L39:
        r23.setConfig(r32);     // Catch: Throwable -> L80
        if (r5.isNull(r14) == false) goto L42;
        String r33 = null;
    L43:
        r23.setType(r33);     // Catch: Throwable -> L80
        if (r5.isNull(r15) == false) goto L46;
        String r34 = null;
    L47:
        r23.setToken(r34);     // Catch: Throwable -> L80
        if (r5.isNull(r3) == false) goto L50;
        String r35 = null;
    L51:
        r23.setObj_token(r35);     // Catch: Throwable -> L80
        if (r5.isNull(r4) == false) goto L54;
        String r36 = null;
    L55:
        r23.setUserToken(r36);     // Catch: Throwable -> L80
        if (r5.isNull(r6) == false) goto L58;
        String r37 = null;
    L59:
        r23.setTenantID(r37);     // Catch: Throwable -> L80
        if (r5.isNull(r1) == false) goto L62;
        String r38 = null;
    L63:
        r23.setUrl(r38);     // Catch: Throwable -> L80
        r23.setSubblock_preload_status(r5.getInt(r17));     // Catch: Throwable -> L80
        r23.setPage(r5.getInt(r18));     // Catch: Throwable -> L80
        r23.setTotalPage(r5.getInt(r19));     // Catch: Throwable -> L80
        if (r5.isNull(r20) == false) goto L66;
        String r39 = null;
    L67:
        r23.setBatchNum(r39);     // Catch: Throwable -> L80
        if (r5.isNull(r21) == false) goto L70;
        String r40 = null;
    L71:
        r23.setLoadFrom(r40);     // Catch: Throwable -> L80
        if (r5.isNull(r22) == false) goto L74;
        String r41 = null;
    L75:
        r23.setCategory(r41);     // Catch: Throwable -> L80
        ResourceData r42 = r23;
    L78:
        r5.close();
        r16.release();
        return r42;
    L74:
        r41 = r5.getString(r22);     // Catch: Throwable -> L80
        goto L75
    L70:
        r40 = r5.getString(r21);     // Catch: Throwable -> L80
        goto L71
    L66:
        r39 = r5.getString(r20);     // Catch: Throwable -> L80
        goto L67
    L62:
        r38 = r5.getString(r1);     // Catch: Throwable -> L80
        goto L63
    L58:
        r37 = r5.getString(r6);     // Catch: Throwable -> L80
        goto L59
    L54:
        r36 = r5.getString(r4);     // Catch: Throwable -> L80
        goto L55
    L50:
        r35 = r5.getString(r3);     // Catch: Throwable -> L80
        goto L51
    L46:
        r34 = r5.getString(r15);     // Catch: Throwable -> L80
        goto L47
    L42:
        r33 = r5.getString(r14);     // Catch: Throwable -> L80
        goto L43
    L38:
        r32 = r5.getString(r13);     // Catch: Throwable -> L80
        goto L39
    L34:
        r31 = false;
        goto L35
    L30:
        r30 = Long.valueOf(r5.getLong(r11));     // Catch: Throwable -> L80
        goto L31
    L26:
        r29 = Long.valueOf(r5.getLong(r10));     // Catch: Throwable -> L80
        goto L27
    L22:
        r28 = r5.getString(r9);     // Catch: Throwable -> L80
        goto L23
    L18:
        r27 = r5.getString(r8);     // Catch: Throwable -> L80
        goto L19
    L14:
        r26 = r5.getString(r7);     // Catch: Throwable -> L80
        goto L15
    L77:
        r42 = null;
    L80:
        th = th;
    L84:
        r5.close();
        r16.release();
        throw th;
    L82:
        th = th;
        r16 = r2;
        goto L84
    L5:
        r2.bindString(2, r24);
        goto L6
    }

    @Override // com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceDataDao
    public List<ResourceDataDelegate> loadResourceDataFullSyncUpTimeMills(long r8, int r10) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT id,resvalue_filepath,obj_token,resKey,id FROM ResourceData WHERE reskey LIKE '%CLIENT_VARS%' AND access_time<= ? AND isNeedSync=0 limit ?", 2);
        r0.bindLong(1, r8);
        r0.bindLong(2, r10);
        this.__db.assertNotSuspendingTransaction();
        Cursor r9 = DBUtil.query(this.__db, r0, false, null);
        ArrayList r3 = new ArrayList(r9.getCount());     // Catch: Throwable -> L22
    L4:
        if (r9.moveToNext() == false) goto L20;
        ResourceDataDelegate r4 = new ResourceDataDelegate();     // Catch: Throwable -> L22
        r4.setId(r9.getInt(0));     // Catch: Throwable -> L22
        if (r9.isNull(1) == false) goto L9;
        String r5 = null;
    L10:
        r4.setResvalueFilePath(r5);     // Catch: Throwable -> L22
        if (r9.isNull(2) == false) goto L13;
        String r6 = null;
    L14:
        r4.setObj_token(r6);     // Catch: Throwable -> L22
        if (r9.isNull(3) == false) goto L17;
        String r7 = null;
    L18:
        r4.setReskey(r7);     // Catch: Throwable -> L22
        r4.setId(r9.getInt(0));     // Catch: Throwable -> L22
        r3.add(r4);     // Catch: Throwable -> L22
        goto L4
    L17:
        r7 = r9.getString(3);     // Catch: Throwable -> L22
        goto L18
    L13:
        r6 = r9.getString(2);     // Catch: Throwable -> L22
        goto L14
    L9:
        r5 = r9.getString(1);     // Catch: Throwable -> L22
        goto L10
    L20:
        r9.close();
        r0.release();
        return r3;
    L22:
        th = move-exception;
        r9.close();
        r0.release();
        throw th;
    }

    @Override // com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceDataDao
    public List<String> loadTokensBySync(boolean r5, long r6) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT DISTINCT obj_token FROM ResourceData WHERE isNeedSync= ? OR (category IS NOT NULL AND access_time> ?)", 2);
        r0.bindLong(1, r5 ? 1 : 0);
        r0.bindLong(2, r6);
        this.__db.assertNotSuspendingTransaction();
        Cursor r7 = DBUtil.query(this.__db, r0, false, null);
        ArrayList r1 = new ArrayList(r7.getCount());     // Catch: Throwable -> L14
    L4:
        if (r7.moveToNext() == false) goto L12;
        if (r7.isNull(0) == false) goto L9;
        String r2 = null;
    L10:
        r1.add(r2);     // Catch: Throwable -> L14
        goto L4
    L9:
        r2 = r7.getString(0);     // Catch: Throwable -> L14
        goto L10
    L12:
        r7.close();
        r0.release();
        return r1;
    L14:
        th = move-exception;
        r7.close();
        r0.release();
        throw th;
    }

    @Override // com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceDataDao
    public int deleteResourceData(String r3, String r4, long r5) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfDeleteResourceData_1.acquire();
        if (r3 != null) goto L5;
        r0.bindNull(1);
    L7:
        if (r4 != null) goto L9;
        r0.bindNull(2);
    L10:
        r0.bindLong(3, r5);
        this.__db.beginTransaction();
        int r6 = r0.executeUpdateDelete();     // Catch: Throwable -> L14
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L14
        this.__db.endTransaction();
        this.__preparedStmtOfDeleteResourceData_1.release(r0);
        return r6;
    L14:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfDeleteResourceData_1.release(r0);
        throw th;
    L9:
        r0.bindString(2, r4);
        goto L10
    L5:
        r0.bindString(1, r3);
        goto L7
    }

    @Override // com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceDataDao
    public ResourceData loadResourceData(String r23, String r24, int r25) {
        RoomSQLiteQuery r3 = RoomSQLiteQuery.acquire("SELECT * FROM ResourceData WHERE obj_token=? and reskey= ? and page = ?", 3);
        if (r23 != null) goto L5;
        r3.bindNull(1);
    L7:
        if (r24 != null) goto L9;
        r3.bindNull(2);
    L10:
        r3.bindLong(3, r25);
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r3, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r6, ResourceData.KEY_ID);     // Catch: Throwable -> L86
        int r7 = CursorUtil.getColumnIndexOrThrow(r6, ResourceData.KEY_RES_KEY);     // Catch: Throwable -> L86
        int r8 = CursorUtil.getColumnIndexOrThrow(r6, ResourceData.KEY_RESOURCE_VALUE);     // Catch: Throwable -> L86
        int r9 = CursorUtil.getColumnIndexOrThrow(r6, ResourceData.KEY_RESOURCE_VALUE_FILE_PATH);     // Catch: Throwable -> L86
        int r10 = CursorUtil.getColumnIndexOrThrow(r6, "update_time");     // Catch: Throwable -> L86
        int r11 = CursorUtil.getColumnIndexOrThrow(r6, ResourceData.ACCESS_TIME);     // Catch: Throwable -> L86
        int r12 = CursorUtil.getColumnIndexOrThrow(r6, "isNeedSync");     // Catch: Throwable -> L86
        int r13 = CursorUtil.getColumnIndexOrThrow(r6, "config");     // Catch: Throwable -> L86
        int r14 = CursorUtil.getColumnIndexOrThrow(r6, ResourceData.KEY_TYPE);     // Catch: Throwable -> L86
        int r15 = CursorUtil.getColumnIndexOrThrow(r6, ResourceData.KEY_TOKEN);     // Catch: Throwable -> L86
        int r2 = CursorUtil.getColumnIndexOrThrow(r6, ResourceData.KEY_OBJ_TOKEN);     // Catch: Throwable -> L86
        int r4 = CursorUtil.getColumnIndexOrThrow(r6, "userToken");     // Catch: Throwable -> L86
        int r5 = CursorUtil.getColumnIndexOrThrow(r6, "tenantID");     // Catch: Throwable -> L86
        int r1 = CursorUtil.getColumnIndexOrThrow(r6, ResourceData.KEY_URL);     // Catch: Throwable -> L86
        RoomSQLiteQuery r16 = r3;
        int r17 = CursorUtil.getColumnIndexOrThrow(r6, ResourceData.KEY_SUBBLOCK_PRELOAD_STATUS);     // Catch: Throwable -> L84
        int r18 = CursorUtil.getColumnIndexOrThrow(r6, ResourceData.KEY_PAGE);     // Catch: Throwable -> L84
        int r19 = CursorUtil.getColumnIndexOrThrow(r6, ResourceData.KEY_TOTAL_PAGE);     // Catch: Throwable -> L84
        int r20 = CursorUtil.getColumnIndexOrThrow(r6, ResourceData.KEY_BATCH_NUM);     // Catch: Throwable -> L84
        int r21 = CursorUtil.getColumnIndexOrThrow(r6, ResourceData.KEY_LOAD_FROM);     // Catch: Throwable -> L84
        int r22 = CursorUtil.getColumnIndexOrThrow(r6, ResourceData.KEY_CATEGORY);     // Catch: Throwable -> L84
        if (r6.moveToFirst() == false) goto L81;
        ResourceData r26 = new ResourceData();     // Catch: Throwable -> L84
        r26.setId(r6.getInt(r0));     // Catch: Throwable -> L84
        if (r6.isNull(r7) == false) goto L18;
        String r27 = null;
    L19:
        r26.setReskey(r27);     // Catch: Throwable -> L84
        if (r6.isNull(r8) == false) goto L22;
        String r28 = null;
    L23:
        r26.setResvalue(r28);     // Catch: Throwable -> L84
        if (r6.isNull(r9) == false) goto L26;
        String r29 = null;
    L27:
        r26.setResvalueFilePath(r29);     // Catch: Throwable -> L84
        if (r6.isNull(r10) == false) goto L30;
        Long r30 = null;
    L31:
        r26.setUpdate_time(r30);     // Catch: Throwable -> L84
        if (r6.isNull(r11) == false) goto L34;
        Long r31 = null;
    L35:
        r26.setAccess_time(r31);     // Catch: Throwable -> L84
        if (r6.getInt(r12) == 0) goto L38;
        boolean r32 = true;
    L39:
        r26.setNeedSync(r32);     // Catch: Throwable -> L84
        if (r6.isNull(r13) == false) goto L42;
        String r33 = null;
    L43:
        r26.setConfig(r33);     // Catch: Throwable -> L84
        if (r6.isNull(r14) == false) goto L46;
        String r34 = null;
    L47:
        r26.setType(r34);     // Catch: Throwable -> L84
        if (r6.isNull(r15) == false) goto L50;
        String r35 = null;
    L51:
        r26.setToken(r35);     // Catch: Throwable -> L84
        if (r6.isNull(r2) == false) goto L54;
        String r36 = null;
    L55:
        r26.setObj_token(r36);     // Catch: Throwable -> L84
        if (r6.isNull(r4) == false) goto L58;
        String r37 = null;
    L59:
        r26.setUserToken(r37);     // Catch: Throwable -> L84
        if (r6.isNull(r5) == false) goto L62;
        String r38 = null;
    L63:
        r26.setTenantID(r38);     // Catch: Throwable -> L84
        if (r6.isNull(r1) == false) goto L66;
        String r39 = null;
    L67:
        r26.setUrl(r39);     // Catch: Throwable -> L84
        r26.setSubblock_preload_status(r6.getInt(r17));     // Catch: Throwable -> L84
        r26.setPage(r6.getInt(r18));     // Catch: Throwable -> L84
        r26.setTotalPage(r6.getInt(r19));     // Catch: Throwable -> L84
        if (r6.isNull(r20) == false) goto L70;
        String r40 = null;
    L71:
        r26.setBatchNum(r40);     // Catch: Throwable -> L84
        if (r6.isNull(r21) == false) goto L74;
        String r41 = null;
    L75:
        r26.setLoadFrom(r41);     // Catch: Throwable -> L84
        if (r6.isNull(r22) == false) goto L78;
        String r42 = null;
    L79:
        r26.setCategory(r42);     // Catch: Throwable -> L84
        ResourceData r43 = r26;
    L82:
        r6.close();
        r16.release();
        return r43;
    L78:
        r42 = r6.getString(r22);     // Catch: Throwable -> L84
        goto L79
    L74:
        r41 = r6.getString(r21);     // Catch: Throwable -> L84
        goto L75
    L70:
        r40 = r6.getString(r20);     // Catch: Throwable -> L84
        goto L71
    L66:
        r39 = r6.getString(r1);     // Catch: Throwable -> L84
        goto L67
    L62:
        r38 = r6.getString(r5);     // Catch: Throwable -> L84
        goto L63
    L58:
        r37 = r6.getString(r4);     // Catch: Throwable -> L84
        goto L59
    L54:
        r36 = r6.getString(r2);     // Catch: Throwable -> L84
        goto L55
    L50:
        r35 = r6.getString(r15);     // Catch: Throwable -> L84
        goto L51
    L46:
        r34 = r6.getString(r14);     // Catch: Throwable -> L84
        goto L47
    L42:
        r33 = r6.getString(r13);     // Catch: Throwable -> L84
        goto L43
    L38:
        r32 = false;
        goto L39
    L34:
        r31 = Long.valueOf(r6.getLong(r11));     // Catch: Throwable -> L84
        goto L35
    L30:
        r30 = Long.valueOf(r6.getLong(r10));     // Catch: Throwable -> L84
        goto L31
    L26:
        r29 = r6.getString(r9);     // Catch: Throwable -> L84
        goto L27
    L22:
        r28 = r6.getString(r8);     // Catch: Throwable -> L84
        goto L23
    L18:
        r27 = r6.getString(r7);     // Catch: Throwable -> L84
        goto L19
    L81:
        r43 = null;
    L84:
        th = th;
    L88:
        r6.close();
        r16.release();
        throw th;
    L86:
        th = th;
        r16 = r3;
        goto L88
    L9:
        r3.bindString(2, r24);
        goto L10
    L5:
        r3.bindString(1, r23);
        goto L7
    }

    @Override // com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceDataDao
    public ResourceData loadResourceDataByCategory(String r23, String r24, int r25) {
        RoomSQLiteQuery r3 = RoomSQLiteQuery.acquire("SELECT * FROM ResourceData WHERE obj_token=? and category= ? and page = ?", 3);
        if (r24 != null) goto L5;
        r3.bindNull(1);
    L7:
        if (r23 != null) goto L9;
        r3.bindNull(2);
    L10:
        r3.bindLong(3, r25);
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r3, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r6, ResourceData.KEY_ID);     // Catch: Throwable -> L86
        int r7 = CursorUtil.getColumnIndexOrThrow(r6, ResourceData.KEY_RES_KEY);     // Catch: Throwable -> L86
        int r8 = CursorUtil.getColumnIndexOrThrow(r6, ResourceData.KEY_RESOURCE_VALUE);     // Catch: Throwable -> L86
        int r9 = CursorUtil.getColumnIndexOrThrow(r6, ResourceData.KEY_RESOURCE_VALUE_FILE_PATH);     // Catch: Throwable -> L86
        int r10 = CursorUtil.getColumnIndexOrThrow(r6, "update_time");     // Catch: Throwable -> L86
        int r11 = CursorUtil.getColumnIndexOrThrow(r6, ResourceData.ACCESS_TIME);     // Catch: Throwable -> L86
        int r12 = CursorUtil.getColumnIndexOrThrow(r6, "isNeedSync");     // Catch: Throwable -> L86
        int r13 = CursorUtil.getColumnIndexOrThrow(r6, "config");     // Catch: Throwable -> L86
        int r14 = CursorUtil.getColumnIndexOrThrow(r6, ResourceData.KEY_TYPE);     // Catch: Throwable -> L86
        int r15 = CursorUtil.getColumnIndexOrThrow(r6, ResourceData.KEY_TOKEN);     // Catch: Throwable -> L86
        int r2 = CursorUtil.getColumnIndexOrThrow(r6, ResourceData.KEY_OBJ_TOKEN);     // Catch: Throwable -> L86
        int r4 = CursorUtil.getColumnIndexOrThrow(r6, "userToken");     // Catch: Throwable -> L86
        int r5 = CursorUtil.getColumnIndexOrThrow(r6, "tenantID");     // Catch: Throwable -> L86
        int r1 = CursorUtil.getColumnIndexOrThrow(r6, ResourceData.KEY_URL);     // Catch: Throwable -> L86
        RoomSQLiteQuery r16 = r3;
        int r17 = CursorUtil.getColumnIndexOrThrow(r6, ResourceData.KEY_SUBBLOCK_PRELOAD_STATUS);     // Catch: Throwable -> L84
        int r18 = CursorUtil.getColumnIndexOrThrow(r6, ResourceData.KEY_PAGE);     // Catch: Throwable -> L84
        int r19 = CursorUtil.getColumnIndexOrThrow(r6, ResourceData.KEY_TOTAL_PAGE);     // Catch: Throwable -> L84
        int r20 = CursorUtil.getColumnIndexOrThrow(r6, ResourceData.KEY_BATCH_NUM);     // Catch: Throwable -> L84
        int r21 = CursorUtil.getColumnIndexOrThrow(r6, ResourceData.KEY_LOAD_FROM);     // Catch: Throwable -> L84
        int r22 = CursorUtil.getColumnIndexOrThrow(r6, ResourceData.KEY_CATEGORY);     // Catch: Throwable -> L84
        if (r6.moveToFirst() == false) goto L81;
        ResourceData r26 = new ResourceData();     // Catch: Throwable -> L84
        r26.setId(r6.getInt(r0));     // Catch: Throwable -> L84
        if (r6.isNull(r7) == false) goto L18;
        String r27 = null;
    L19:
        r26.setReskey(r27);     // Catch: Throwable -> L84
        if (r6.isNull(r8) == false) goto L22;
        String r28 = null;
    L23:
        r26.setResvalue(r28);     // Catch: Throwable -> L84
        if (r6.isNull(r9) == false) goto L26;
        String r29 = null;
    L27:
        r26.setResvalueFilePath(r29);     // Catch: Throwable -> L84
        if (r6.isNull(r10) == false) goto L30;
        Long r30 = null;
    L31:
        r26.setUpdate_time(r30);     // Catch: Throwable -> L84
        if (r6.isNull(r11) == false) goto L34;
        Long r31 = null;
    L35:
        r26.setAccess_time(r31);     // Catch: Throwable -> L84
        if (r6.getInt(r12) == 0) goto L38;
        boolean r32 = true;
    L39:
        r26.setNeedSync(r32);     // Catch: Throwable -> L84
        if (r6.isNull(r13) == false) goto L42;
        String r33 = null;
    L43:
        r26.setConfig(r33);     // Catch: Throwable -> L84
        if (r6.isNull(r14) == false) goto L46;
        String r34 = null;
    L47:
        r26.setType(r34);     // Catch: Throwable -> L84
        if (r6.isNull(r15) == false) goto L50;
        String r35 = null;
    L51:
        r26.setToken(r35);     // Catch: Throwable -> L84
        if (r6.isNull(r2) == false) goto L54;
        String r36 = null;
    L55:
        r26.setObj_token(r36);     // Catch: Throwable -> L84
        if (r6.isNull(r4) == false) goto L58;
        String r37 = null;
    L59:
        r26.setUserToken(r37);     // Catch: Throwable -> L84
        if (r6.isNull(r5) == false) goto L62;
        String r38 = null;
    L63:
        r26.setTenantID(r38);     // Catch: Throwable -> L84
        if (r6.isNull(r1) == false) goto L66;
        String r39 = null;
    L67:
        r26.setUrl(r39);     // Catch: Throwable -> L84
        r26.setSubblock_preload_status(r6.getInt(r17));     // Catch: Throwable -> L84
        r26.setPage(r6.getInt(r18));     // Catch: Throwable -> L84
        r26.setTotalPage(r6.getInt(r19));     // Catch: Throwable -> L84
        if (r6.isNull(r20) == false) goto L70;
        String r40 = null;
    L71:
        r26.setBatchNum(r40);     // Catch: Throwable -> L84
        if (r6.isNull(r21) == false) goto L74;
        String r41 = null;
    L75:
        r26.setLoadFrom(r41);     // Catch: Throwable -> L84
        if (r6.isNull(r22) == false) goto L78;
        String r42 = null;
    L79:
        r26.setCategory(r42);     // Catch: Throwable -> L84
        ResourceData r43 = r26;
    L82:
        r6.close();
        r16.release();
        return r43;
    L78:
        r42 = r6.getString(r22);     // Catch: Throwable -> L84
        goto L79
    L74:
        r41 = r6.getString(r21);     // Catch: Throwable -> L84
        goto L75
    L70:
        r40 = r6.getString(r20);     // Catch: Throwable -> L84
        goto L71
    L66:
        r39 = r6.getString(r1);     // Catch: Throwable -> L84
        goto L67
    L62:
        r38 = r6.getString(r5);     // Catch: Throwable -> L84
        goto L63
    L58:
        r37 = r6.getString(r4);     // Catch: Throwable -> L84
        goto L59
    L54:
        r36 = r6.getString(r2);     // Catch: Throwable -> L84
        goto L55
    L50:
        r35 = r6.getString(r15);     // Catch: Throwable -> L84
        goto L51
    L46:
        r34 = r6.getString(r14);     // Catch: Throwable -> L84
        goto L47
    L42:
        r33 = r6.getString(r13);     // Catch: Throwable -> L84
        goto L43
    L38:
        r32 = false;
        goto L39
    L34:
        r31 = Long.valueOf(r6.getLong(r11));     // Catch: Throwable -> L84
        goto L35
    L30:
        r30 = Long.valueOf(r6.getLong(r10));     // Catch: Throwable -> L84
        goto L31
    L26:
        r29 = r6.getString(r9);     // Catch: Throwable -> L84
        goto L27
    L22:
        r28 = r6.getString(r8);     // Catch: Throwable -> L84
        goto L23
    L18:
        r27 = r6.getString(r7);     // Catch: Throwable -> L84
        goto L19
    L81:
        r43 = null;
    L84:
        th = th;
    L88:
        r6.close();
        r16.release();
        throw th;
    L86:
        th = th;
        r16 = r3;
        goto L88
    L9:
        r3.bindString(2, r23);
        goto L10
    L5:
        r3.bindString(1, r24);
        goto L7
    }

    @Override // com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceDataDao
    public List<ResourceDataDelegate> loadResourceDataFullSyncUpTimeMillsV2(long r7, List<String> r9, int r10) {
        StringBuilder r0 = StringUtil.newStringBuilder();
        r0.append("SELECT obj_token,resvalue_filepath,id,access_time FROM ResourceData WHERE access_time<= ");
        r0.append("?");
        r0.append(" AND obj_token NOT IN(");
        int r2 = r9.size();
        StringUtil.appendPlaceholders(r0, r2);
        r0.append(") limit ");
        r0.append("?");
        int r3 = r2 + 2;
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire(r0.toString(), r3);
        r1.bindLong(1, r7);
        Iterator<String> r8 = r9.iterator();
        int r11 = 2;
    L4:
        if (r8.hasNext() == false) goto L10;
        String r12 = r8.next();
        if (r12 != null) goto L8;
        r1.bindNull(r11);
    L9:
        r11 = r11 + 1;
        goto L4
    L8:
        r1.bindString(r11, r12);
        goto L9
    L10:
        r1.bindLong(r3, r10);
        this.__db.assertNotSuspendingTransaction();
        Cursor r13 = DBUtil.query(this.__db, r1, false, null);
        ArrayList r14 = new ArrayList(r13.getCount());     // Catch: Throwable -> L30
    L12:
        if (r13.moveToNext() == false) goto L28;
        ResourceDataDelegate r4 = new ResourceDataDelegate();     // Catch: Throwable -> L30
        if (r13.isNull(0) == false) goto L17;
        String r5 = null;
    L18:
        r4.setObj_token(r5);     // Catch: Throwable -> L30
        if (r13.isNull(1) == false) goto L21;
        String r6 = null;
    L22:
        r4.setResvalueFilePath(r6);     // Catch: Throwable -> L30
        r4.setId(r13.getInt(2));     // Catch: Throwable -> L30
        if (r13.isNull(3) == false) goto L25;
        Long r15 = null;
    L26:
        r4.setAccessTime(r15);     // Catch: Throwable -> L30
        r14.add(r4);     // Catch: Throwable -> L30
        goto L12
    L25:
        r15 = Long.valueOf(r13.getLong(3));     // Catch: Throwable -> L30
        goto L26
    L21:
        r6 = r13.getString(1);     // Catch: Throwable -> L30
        goto L22
    L17:
        r5 = r13.getString(0);     // Catch: Throwable -> L30
        goto L18
    L28:
        r13.close();
        r1.release();
        return r14;
    L30:
        th = move-exception;
        r13.close();
        r1.release();
        throw th;
    }

    @Override // com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceDataDao
    public ResourceDataSubInfo loadSubInfo(String r6, String r7, int r8) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT id,subblock_preload_status,page,total_page,resvalue_filepath FROM ResourceData WHERE obj_token = ? AND reskey = ? AND page = ?", 3);
        if (r7 != null) goto L5;
        r0.bindNull(1);
    L7:
        if (r6 != null) goto L9;
        r0.bindNull(2);
    L10:
        r0.bindLong(3, r8);
        this.__db.assertNotSuspendingTransaction();
        ResourceDataSubInfo r3 = null;
        Cursor r9 = DBUtil.query(this.__db, r0, false, null);
    L16:
        th = move-exception;
        r9.close();
        r0.release();
        throw th;
    L12:
        if (r9.moveToFirst() == false) goto L14;
        r3 = new ResourceDataSubInfo();     // Catch: Throwable -> L16
        r3.setId(r9.getInt(0));     // Catch: Throwable -> L16
        r3.setSubblock_preload_status(r9.getInt(1));     // Catch: Throwable -> L16
        r3.setPage(r9.getInt(2));     // Catch: Throwable -> L16
        r3.setTotalPage(r9.getInt(3));     // Catch: Throwable -> L16
    L14:
        r9.close();
        r0.release();
        return r3;
    L9:
        r0.bindString(2, r6);
        goto L10
    L5:
        r0.bindString(1, r7);
        goto L7
    }

    @Override // com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceDataDao
    public int updateResourceDataToken(String r4, String r5, List<Integer> r6) {
        this.__db.assertNotSuspendingTransaction();
        StringBuilder r0 = StringUtil.newStringBuilder();
        r0.append("UPDATE ResourceData SET obj_token = ");
        r0.append("?");
        r0.append(", token = ");
        r0.append("?");
        r0.append(" WHERE id in (");
        StringUtil.appendPlaceholders(r0, r6.size());
        r0.append(")");
        SupportSQLiteStatement r1 = this.__db.compileStatement(r0.toString());
        if (r4 != null) goto L5;
        r1.bindNull(1);
    L7:
        if (r5 != null) goto L9;
        r1.bindNull(2);
    L10:
        Iterator<Integer> r7 = r6.iterator();
        int r8 = 3;
    L12:
        if (r7.hasNext() == false) goto L18;
        Integer r9 = r7.next();
        if (r9 != null) goto L16;
        r1.bindNull(r8);
    L17:
        r8 = r8 + 1;
        goto L12
    L16:
        r1.bindLong(r8, r9.intValue());
        goto L17
    L18:
        this.__db.beginTransaction();
        int r10 = r1.executeUpdateDelete();     // Catch: Throwable -> L22
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L22
        this.__db.endTransaction();
        return r10;
    L22:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    L9:
        r1.bindString(2, r5);
        goto L10
    L5:
        r1.bindString(1, r4);
        goto L7
    }

    @Override // com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceDataDao
    public List<String> loadDocxWithClientVarsWithoutSSR(int r4, String r5, String r6, long r7, int r9) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT A.obj_token FROM (SELECT DISTINCT obj_token FROM ResourceData WHERE reskey = ? AND type IS NOT 'doc' AND update_time>= ? order by update_time desc limit ?) AS A LEFT OUTER JOIN (SELECT DISTINCT obj_token FROM ResourceData WHERE reskey = ? AND resvalue IS NOT NULL) AS B on A.obj_token = B.obj_token WHERE B.obj_token IS NULL limit ?", 5);
        if (r5 != null) goto L5;
        r0.bindNull(1);
    L6:
        r0.bindLong(2, r7);
        r0.bindLong(3, r4);
        if (r6 != null) goto L9;
        r0.bindNull(4);
    L10:
        r0.bindLong(5, r9);
        this.__db.assertNotSuspendingTransaction();
        Cursor r8 = DBUtil.query(this.__db, r0, false, null);
        ArrayList r10 = new ArrayList(r8.getCount());     // Catch: Throwable -> L22
    L12:
        if (r8.moveToNext() == false) goto L20;
        if (r8.isNull(0) == false) goto L17;
        String r11 = null;
    L18:
        r10.add(r11);     // Catch: Throwable -> L22
        goto L12
    L17:
        r11 = r8.getString(0);     // Catch: Throwable -> L22
        goto L18
    L20:
        r8.close();
        r0.release();
        return r10;
    L22:
        th = move-exception;
        r8.close();
        r0.release();
        throw th;
    L9:
        r0.bindString(4, r6);
        goto L10
    L5:
        r0.bindString(1, r5);
        goto L6
    }
}
