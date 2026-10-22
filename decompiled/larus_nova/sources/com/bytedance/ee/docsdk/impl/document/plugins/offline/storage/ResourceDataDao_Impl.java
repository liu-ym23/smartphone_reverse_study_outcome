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

/* JADX INFO: loaded from: classes18.dex */
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
        SupportSQLiteStatement r100 = this.__preparedStmtOfDeleteAllPageData.acquire();
        this.__db.beginTransaction();
        int r101 = r100.executeUpdateDelete();     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        this.__preparedStmtOfDeleteAllPageData.release(r100);
        return r101;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfDeleteAllPageData.release(r100);
        throw th;
    }

    @Override // com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceDataDao
    public int deleteAllResource() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r100 = this.__preparedStmtOfDeleteAllResource.acquire();
        this.__db.beginTransaction();
        int r101 = r100.executeUpdateDelete();     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        this.__preparedStmtOfDeleteAllResource.release(r100);
        return r101;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfDeleteAllResource.release(r100);
        throw th;
    }

    @Override // com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceDataDao
    public List<String> getTokenList() {
        RoomSQLiteQuery r100 = RoomSQLiteQuery.acquire("SELECT obj_token FROM ResourceData group by obj_token", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor r101 = DBUtil.query(this.__db, r100, false, null);
        ArrayList r102 = new ArrayList(r101.getCount());     // Catch: Throwable -> L14
    L4:
        if (r101.moveToNext() == false) goto L12;
        if (r101.isNull(0) == false) goto L9;
        String r103 = null;
    L10:
        r102.add(r103);     // Catch: Throwable -> L14
        goto L4
    L9:
        r103 = r101.getString(0);     // Catch: Throwable -> L14
        goto L10
    L12:
        r101.close();
        r100.release();
        return r102;
    L14:
        th = move-exception;
        r101.close();
        r100.release();
        throw th;
    }

    @Override // com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceDataDao
    public List<ResourceDataDelegate> loadAllPageResourceDelegate() {
        RoomSQLiteQuery r100 = RoomSQLiteQuery.acquire("SELECT id, resvalue_filepath FROM ResourceData WHERE total_page > page", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor r101 = DBUtil.query(this.__db, r100, false, null);
        ArrayList r102 = new ArrayList(r101.getCount());     // Catch: Throwable -> L14
    L4:
        if (r101.moveToNext() == false) goto L12;
        ResourceDataDelegate r103 = new ResourceDataDelegate();     // Catch: Throwable -> L14
        r103.setId(r101.getInt(0));     // Catch: Throwable -> L14
        if (r101.isNull(1) == false) goto L9;
        String r104 = null;
    L10:
        r103.setResvalueFilePath(r104);     // Catch: Throwable -> L14
        r102.add(r103);     // Catch: Throwable -> L14
        goto L4
    L9:
        r104 = r101.getString(1);     // Catch: Throwable -> L14
        goto L10
    L12:
        r101.close();
        r100.release();
        return r102;
    L14:
        th = move-exception;
        r101.close();
        r100.release();
        throw th;
    }

    @Override // com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceDataDao
    public List<ResourceDataDelegate> loadDirtyPageData() {
        RoomSQLiteQuery r100 = RoomSQLiteQuery.acquire("Select a.* from ResourceData a join (Select distinct id,reskey,obj_token from (Select id,reskey,obj_token,batch_num,total_page,max(page) as max_page from ResourceData group by reskey,obj_token,batch_num,total_page) where total_page > 1 and max_page + 1 < total_page)b\non a.reskey=b.reskey and a.obj_token=b.obj_token", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor r101 = DBUtil.query(this.__db, r100, false, null);
        int r102 = CursorUtil.getColumnIndexOrThrow(r101, "id");     // Catch: Throwable -> L38
        int r103 = CursorUtil.getColumnIndexOrThrow(r101, ResourceData.KEY_RES_KEY);     // Catch: Throwable -> L38
        int r104 = CursorUtil.getColumnIndexOrThrow(r101, ResourceData.KEY_RESOURCE_VALUE_FILE_PATH);     // Catch: Throwable -> L38
        int r105 = CursorUtil.getColumnIndexOrThrow(r101, ResourceData.ACCESS_TIME);     // Catch: Throwable -> L38
        int r106 = CursorUtil.getColumnIndexOrThrow(r101, "type");     // Catch: Throwable -> L38
        int r107 = CursorUtil.getColumnIndexOrThrow(r101, "token");     // Catch: Throwable -> L38
        int r108 = CursorUtil.getColumnIndexOrThrow(r101, "obj_token");     // Catch: Throwable -> L38
        int r110 = CursorUtil.getColumnIndexOrThrow(r101, "url");     // Catch: Throwable -> L38
        ArrayList r111 = new ArrayList(r101.getCount());     // Catch: Throwable -> L38
    L4:
        if (r101.moveToNext() == false) goto L36;
        ResourceDataDelegate r112 = new ResourceDataDelegate();     // Catch: Throwable -> L38
        r112.setId(r101.getInt(r102));     // Catch: Throwable -> L38
        if (r101.isNull(r103) == false) goto L9;
        String r113 = null;
    L10:
        r112.setReskey(r113);     // Catch: Throwable -> L38
        if (r101.isNull(r104) == false) goto L13;
        String r114 = null;
    L14:
        r112.setResvalueFilePath(r114);     // Catch: Throwable -> L38
        if (r101.isNull(r105) == false) goto L17;
        Long r115 = null;
    L18:
        r112.setAccessTime(r115);     // Catch: Throwable -> L38
        if (r101.isNull(r106) == false) goto L21;
        String r116 = null;
    L22:
        r112.setType(r116);     // Catch: Throwable -> L38
        if (r101.isNull(r107) == false) goto L25;
        String r117 = null;
    L26:
        r112.setToken(r117);     // Catch: Throwable -> L38
        if (r101.isNull(r108) == false) goto L29;
        String r118 = null;
    L30:
        r112.setObj_token(r118);     // Catch: Throwable -> L38
        if (r101.isNull(r110) == false) goto L33;
        String r119 = null;
    L34:
        r112.setUrl(r119);     // Catch: Throwable -> L38
        r111.add(r112);     // Catch: Throwable -> L38
        goto L4
    L33:
        r119 = r101.getString(r110);     // Catch: Throwable -> L38
        goto L34
    L29:
        r118 = r101.getString(r108);     // Catch: Throwable -> L38
        goto L30
    L25:
        r117 = r101.getString(r107);     // Catch: Throwable -> L38
        goto L26
    L21:
        r116 = r101.getString(r106);     // Catch: Throwable -> L38
        goto L22
    L17:
        r115 = Long.valueOf(r101.getLong(r105));     // Catch: Throwable -> L38
        goto L18
    L13:
        r114 = r101.getString(r104);     // Catch: Throwable -> L38
        goto L14
    L9:
        r113 = r101.getString(r103);     // Catch: Throwable -> L38
        goto L10
    L36:
        r101.close();
        r100.release();
        return r111;
    L38:
        th = move-exception;
        r101.close();
        r100.release();
        throw th;
    }

    @Override // com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceDataDao
    public LiveData<List<String>> loadUnSyncDocuments() {
        final RoomSQLiteQuery r100 = RoomSQLiteQuery.acquire("SELECT DISTINCT obj_token FROM ResourceData WHERE isNeedSync= 1", 0);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{ResourceData.TABLE_NAME}, false, new AnonymousClass11(this, r100));
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    public ResourceDataDao_Impl(final RoomDatabase r100) {
        this.__db = r100;
        this.__insertionAdapterOfResourceData = new AnonymousClass1(this, r100);
        this.__updateAdapterOfResourceData = new AnonymousClass2(this, r100);
        this.__preparedStmtOfDeleteResourceDataByDocToken = new AnonymousClass3(this, r100);
        this.__preparedStmtOfDeleteResourceDataByDocToken_1 = new AnonymousClass4(this, r100);
        this.__preparedStmtOfDeleteResourceData = new AnonymousClass5(this, r100);
        this.__preparedStmtOfDeleteResourceData_1 = new AnonymousClass6(this, r100);
        this.__preparedStmtOfDeleteAllPageData = new AnonymousClass7(this, r100);
        this.__preparedStmtOfDeleteAllPageData_1 = new AnonymousClass8(this, r100);
        this.__preparedStmtOfDeleteAllResource = new AnonymousClass9(this, r100);
        this.__preparedStmtOfDeleteAllResource_1 = new AnonymousClass10(this, r100);
    }

    public static /* synthetic */ RoomDatabase access$000(ResourceDataDao_Impl r100) {
        return r100.__db;
    }

    @Override // com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceDataDao
    public int deleteAllPageData(long r100) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r101 = this.__preparedStmtOfDeleteAllPageData_1.acquire();
        r101.bindLong(1, r100);
        this.__db.beginTransaction();
        int r102 = r101.executeUpdateDelete();     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        this.__preparedStmtOfDeleteAllPageData_1.release(r101);
        return r102;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfDeleteAllPageData_1.release(r101);
        throw th;
    }

    @Override // com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceDataDao
    public int deleteAllResource(long r100) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r101 = this.__preparedStmtOfDeleteAllResource_1.acquire();
        r101.bindLong(1, r100);
        this.__db.beginTransaction();
        int r102 = r101.executeUpdateDelete();     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        this.__preparedStmtOfDeleteAllResource_1.release(r101);
        return r102;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfDeleteAllResource_1.release(r101);
        throw th;
    }

    @Override // com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceDataDao
    public int deleteResourceDataByDocToken(String r100) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r101 = this.__preparedStmtOfDeleteResourceDataByDocToken.acquire();
        if (r100 != null) goto L5;
        r101.bindNull(1);
    L6:
        this.__db.beginTransaction();
        int r102 = r101.executeUpdateDelete();     // Catch: Throwable -> L10
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L10
        this.__db.endTransaction();
        this.__preparedStmtOfDeleteResourceDataByDocToken.release(r101);
        return r102;
    L10:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfDeleteResourceDataByDocToken.release(r101);
        throw th;
    L5:
        r101.bindString(1, r100);
        goto L6
    }

    @Override // com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceDataDao
    public int deleteResourceDataByTokens(List<String> r100) {
        this.__db.assertNotSuspendingTransaction();
        StringBuilder r101 = StringUtil.newStringBuilder();
        r101.append("DELETE FROM ResourceData WHERE obj_token IN(");
        StringUtil.appendPlaceholders(r101, r100.size());
        r101.append(")");
        String r102 = r101.toString();
        SupportSQLiteStatement r103 = this.__db.compileStatement(r102);
        Iterator<String> r104 = r100.iterator();
        int r105 = 1;
    L4:
        if (r104.hasNext() == false) goto L10;
        String r106 = r104.next();
        if (r106 != null) goto L8;
        r103.bindNull(r105);
    L9:
        r105 = r105 + 1;
        goto L4
    L8:
        r103.bindString(r105, r106);
        goto L9
    L10:
        this.__db.beginTransaction();
        int r107 = r103.executeUpdateDelete();     // Catch: Throwable -> L14
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L14
        this.__db.endTransaction();
        return r107;
    L14:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceDataDao
    public long insertResourceData(ResourceData r100) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r101 = this.__insertionAdapterOfResourceData.insertAndReturnId(r100);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r101;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceDataDao
    public List<ResourceDataDelegate> loadAllPageResourceDelegate(long r100) {
        RoomSQLiteQuery r101 = RoomSQLiteQuery.acquire("SELECT id, resvalue_filepath FROM ResourceData WHERE total_page > page AND (category IS NULL OR (category IS NOT NULL AND access_time<= ?))", 1);
        r101.bindLong(1, r100);
        this.__db.assertNotSuspendingTransaction();
        Cursor r102 = DBUtil.query(this.__db, r101, false, null);
        ArrayList r103 = new ArrayList(r102.getCount());     // Catch: Throwable -> L14
    L4:
        if (r102.moveToNext() == false) goto L12;
        ResourceDataDelegate r104 = new ResourceDataDelegate();     // Catch: Throwable -> L14
        r104.setId(r102.getInt(0));     // Catch: Throwable -> L14
        if (r102.isNull(1) == false) goto L9;
        String r105 = null;
    L10:
        r104.setResvalueFilePath(r105);     // Catch: Throwable -> L14
        r103.add(r104);     // Catch: Throwable -> L14
        goto L4
    L9:
        r105 = r102.getString(1);     // Catch: Throwable -> L14
        goto L10
    L12:
        r102.close();
        r101.release();
        return r103;
    L14:
        th = move-exception;
        r102.close();
        r101.release();
        throw th;
    }

    @Override // com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceDataDao
    public LiveData<List<String>> loadCacheDocumentTokens(int r100) {
        final RoomSQLiteQuery r101 = RoomSQLiteQuery.acquire("SELECT DISTINCT obj_token FROM ResourceData WHERE reskey LIKE '%CLIENT_VARS%' order by update_time desc limit ?", 1);
        r101.bindLong(1, r100);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{ResourceData.TABLE_NAME}, false, new AnonymousClass12(this, r101));
    }

    @Override // com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceDataDao
    public List<ResourceDataDelegate> loadResDataInDiskCache(int r100) {
        RoomSQLiteQuery r101 = RoomSQLiteQuery.acquire("SELECT obj_token,resvalue_filepath,id FROM ResourceData WHERE resvalue_filepath NOT NULL limit ?", 1);
        r101.bindLong(1, r100);
        this.__db.assertNotSuspendingTransaction();
        Cursor r102 = DBUtil.query(this.__db, r101, false, null);
        ArrayList r103 = new ArrayList(r102.getCount());     // Catch: Throwable -> L18
    L4:
        if (r102.moveToNext() == false) goto L16;
        ResourceDataDelegate r104 = new ResourceDataDelegate();     // Catch: Throwable -> L18
        if (r102.isNull(0) == false) goto L9;
        String r105 = null;
    L10:
        r104.setObj_token(r105);     // Catch: Throwable -> L18
        if (r102.isNull(1) == false) goto L13;
        String r106 = null;
    L14:
        r104.setResvalueFilePath(r106);     // Catch: Throwable -> L18
        r104.setId(r102.getInt(2));     // Catch: Throwable -> L18
        r103.add(r104);     // Catch: Throwable -> L18
        goto L4
    L13:
        r106 = r102.getString(1);     // Catch: Throwable -> L18
        goto L14
    L9:
        r105 = r102.getString(0);     // Catch: Throwable -> L18
        goto L10
    L16:
        r102.close();
        r101.release();
        return r103;
    L18:
        th = move-exception;
        r102.close();
        r101.release();
        throw th;
    }

    @Override // com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceDataDao
    public List<Integer> loadResIdsByObjToken(String r100) {
        RoomSQLiteQuery r101 = RoomSQLiteQuery.acquire("SELECT DISTINCT id FROM ResourceData WHERE obj_token= ?", 1);
        if (r100 != null) goto L5;
        r101.bindNull(1);
    L6:
        this.__db.assertNotSuspendingTransaction();
        Cursor r102 = DBUtil.query(this.__db, r101, false, null);
        ArrayList r103 = new ArrayList(r102.getCount());     // Catch: Throwable -> L18
    L8:
        if (r102.moveToNext() == false) goto L16;
        if (r102.isNull(0) == false) goto L13;
        Integer r104 = null;
    L14:
        r103.add(r104);     // Catch: Throwable -> L18
        goto L8
    L13:
        r104 = Integer.valueOf(r102.getInt(0));     // Catch: Throwable -> L18
        goto L14
    L16:
        r102.close();
        r101.release();
        return r103;
    L18:
        th = move-exception;
        r102.close();
        r101.release();
        throw th;
    L5:
        r101.bindString(1, r100);
        goto L6
    }

    @Override // com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceDataDao
    public List<ResourceDataDelegate> loadResourceDataByDocToken(String r100) {
        RoomSQLiteQuery r101 = RoomSQLiteQuery.acquire("SELECT resvalue_filepath,id FROM ResourceData WHERE obj_token= ?", 1);
        if (r100 != null) goto L5;
        r101.bindNull(1);
    L6:
        this.__db.assertNotSuspendingTransaction();
        Cursor r102 = DBUtil.query(this.__db, r101, false, null);
        ArrayList r103 = new ArrayList(r102.getCount());     // Catch: Throwable -> L18
    L8:
        if (r102.moveToNext() == false) goto L16;
        ResourceDataDelegate r104 = new ResourceDataDelegate();     // Catch: Throwable -> L18
        if (r102.isNull(0) == false) goto L13;
        String r105 = null;
    L14:
        r104.setResvalueFilePath(r105);     // Catch: Throwable -> L18
        r104.setId(r102.getInt(1));     // Catch: Throwable -> L18
        r103.add(r104);     // Catch: Throwable -> L18
        goto L8
    L13:
        r105 = r102.getString(0);     // Catch: Throwable -> L18
        goto L14
    L16:
        r102.close();
        r101.release();
        return r103;
    L18:
        th = move-exception;
        r102.close();
        r101.release();
        throw th;
    L5:
        r101.bindString(1, r100);
        goto L6
    }

    @Override // com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceDataDao
    public List<ResourceDataDelegate> loadResourceDataByNeedSync(boolean r100) {
        RoomSQLiteQuery r101 = RoomSQLiteQuery.acquire("SELECT DISTINCT obj_token,type,url,id FROM ResourceData WHERE isNeedSync= ?", 1);
        r101.bindLong(1, r100 ? 1 : 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor r102 = DBUtil.query(this.__db, r101, false, null);
        ArrayList r103 = new ArrayList(r102.getCount());     // Catch: Throwable -> L22
    L4:
        if (r102.moveToNext() == false) goto L20;
        ResourceDataDelegate r104 = new ResourceDataDelegate();     // Catch: Throwable -> L22
        if (r102.isNull(0) == false) goto L9;
        String r105 = null;
    L10:
        r104.setObj_token(r105);     // Catch: Throwable -> L22
        if (r102.isNull(1) == false) goto L13;
        String r106 = null;
    L14:
        r104.setType(r106);     // Catch: Throwable -> L22
        if (r102.isNull(2) == false) goto L17;
        String r107 = null;
    L18:
        r104.setUrl(r107);     // Catch: Throwable -> L22
        r104.setId(r102.getInt(3));     // Catch: Throwable -> L22
        r103.add(r104);     // Catch: Throwable -> L22
        goto L4
    L17:
        r107 = r102.getString(2);     // Catch: Throwable -> L22
        goto L18
    L13:
        r106 = r102.getString(1);     // Catch: Throwable -> L22
        goto L14
    L9:
        r105 = r102.getString(0);     // Catch: Throwable -> L22
        goto L10
    L20:
        r102.close();
        r101.release();
        return r103;
    L22:
        th = move-exception;
        r102.close();
        r101.release();
        throw th;
    }

    @Override // com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceDataDao
    public List<String> loadTokensBySync(boolean r100) {
        RoomSQLiteQuery r101 = RoomSQLiteQuery.acquire("SELECT DISTINCT obj_token FROM ResourceData WHERE isNeedSync= ?", 1);
        r101.bindLong(1, r100 ? 1 : 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor r102 = DBUtil.query(this.__db, r101, false, null);
        ArrayList r103 = new ArrayList(r102.getCount());     // Catch: Throwable -> L14
    L4:
        if (r102.moveToNext() == false) goto L12;
        if (r102.isNull(0) == false) goto L9;
        String r104 = null;
    L10:
        r103.add(r104);     // Catch: Throwable -> L14
        goto L4
    L9:
        r104 = r102.getString(0);     // Catch: Throwable -> L14
        goto L10
    L12:
        r102.close();
        r101.release();
        return r103;
    L14:
        th = move-exception;
        r102.close();
        r101.release();
        throw th;
    }

    @Override // com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceDataDao
    public int updateResourceData(ResourceData r100) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r101 = this.__updateAdapterOfResourceData.handle(r100) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r101;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceDataDao
    public int deleteResourceData(String r100, String r101) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r102 = this.__preparedStmtOfDeleteResourceData.acquire();
        if (r100 != null) goto L5;
        r102.bindNull(1);
    L7:
        if (r101 != null) goto L9;
        r102.bindNull(2);
    L10:
        this.__db.beginTransaction();
        int r103 = r102.executeUpdateDelete();     // Catch: Throwable -> L14
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L14
        this.__db.endTransaction();
        this.__preparedStmtOfDeleteResourceData.release(r102);
        return r103;
    L14:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfDeleteResourceData.release(r102);
        throw th;
    L9:
        r102.bindString(2, r101);
        goto L10
    L5:
        r102.bindString(1, r100);
        goto L7
    }

    @Override // com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceDataDao
    public int deleteResourceDataByDocToken(String r100, long r101) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r102 = this.__preparedStmtOfDeleteResourceDataByDocToken_1.acquire();
        if (r100 != null) goto L5;
        r102.bindNull(1);
    L6:
        r102.bindLong(2, r101);
        this.__db.beginTransaction();
        int r103 = r102.executeUpdateDelete();     // Catch: Throwable -> L10
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L10
        this.__db.endTransaction();
        this.__preparedStmtOfDeleteResourceDataByDocToken_1.release(r102);
        return r103;
    L10:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfDeleteResourceDataByDocToken_1.release(r102);
        throw th;
    L5:
        r102.bindString(1, r100);
        goto L6
    }

    @Override // com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceDataDao
    public int deleteResourceDataByTokens(List<String> r100, long r101) {
        this.__db.assertNotSuspendingTransaction();
        StringBuilder r102 = StringUtil.newStringBuilder();
        r102.append("DELETE FROM ResourceData WHERE obj_token IN(");
        int r103 = r100.size();
        StringUtil.appendPlaceholders(r102, r103);
        r102.append(") AND (category IS NULL OR (category IS NOT NULL AND access_time<= ");
        r102.append("?");
        r102.append("))");
        String r104 = r102.toString();
        SupportSQLiteStatement r105 = this.__db.compileStatement(r104);
        Iterator<String> r106 = r100.iterator();
        int r107 = 1;
    L4:
        if (r106.hasNext() == false) goto L10;
        String r108 = r106.next();
        if (r108 != null) goto L8;
        r105.bindNull(r107);
    L9:
        r107 = r107 + 1;
        goto L4
    L8:
        r105.bindString(r107, r108);
        goto L9
    L10:
        r105.bindLong(r103 + 1, r101);
        this.__db.beginTransaction();
        int r109 = r105.executeUpdateDelete();     // Catch: Throwable -> L14
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L14
        this.__db.endTransaction();
        return r109;
    L14:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceDataDao
    public List<String> loadCachedTokensBykey(List<String> r100, String r101) {
        StringBuilder r102 = StringUtil.newStringBuilder();
        r102.append("SELECT distinct obj_token FROM ResourceData WHERE obj_token IN (");
        int r103 = r100.size();
        StringUtil.appendPlaceholders(r102, r103);
        r102.append(") AND reskey = ");
        r102.append("?");
        int r104 = 1;
        int r105 = r103 + 1;
        RoomSQLiteQuery r106 = RoomSQLiteQuery.acquire(r102.toString(), r105);
        Iterator<String> r107 = r100.iterator();
    L4:
        if (r107.hasNext() == false) goto L10;
        String r108 = r107.next();
        if (r108 != null) goto L8;
        r106.bindNull(r104);
    L9:
        r104 = r104 + 1;
        goto L4
    L8:
        r106.bindString(r104, r108);
        goto L9
    L10:
        if (r101 != null) goto L12;
        r106.bindNull(r105);
    L13:
        this.__db.assertNotSuspendingTransaction();
        Cursor r109 = DBUtil.query(this.__db, r106, false, null);
        ArrayList r110 = new ArrayList(r109.getCount());     // Catch: Throwable -> L25
    L15:
        if (r109.moveToNext() == false) goto L23;
        if (r109.isNull(0) == false) goto L20;
        String r111 = null;
    L21:
        r110.add(r111);     // Catch: Throwable -> L25
        goto L15
    L20:
        r111 = r109.getString(0);     // Catch: Throwable -> L25
        goto L21
    L23:
        r109.close();
        r106.release();
        return r110;
    L25:
        th = move-exception;
        r109.close();
        r106.release();
        throw th;
    L12:
        r106.bindString(r105, r101);
        goto L13
    }

    @Override // com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceDataDao
    public List<ResourceDataDelegate> loadDeleteResourceDataByUpdateTime(List<String> r100, int r101) {
        StringBuilder r102 = StringUtil.newStringBuilder();
        r102.append("SELECT resvalue_filepath,obj_token,id,access_time FROM ResourceData WHERE obj_token NOT IN(");
        int r103 = r100.size();
        StringUtil.appendPlaceholders(r102, r103);
        r102.append(") AND reskey LIKE '%CLIENT_VARS%' order by update_time asc limit ");
        r102.append("?");
        int r104 = r103 + 1;
        RoomSQLiteQuery r105 = RoomSQLiteQuery.acquire(r102.toString(), r104);
        Iterator<String> r106 = r100.iterator();
        int r107 = 1;
    L4:
        if (r106.hasNext() == false) goto L10;
        String r108 = r106.next();
        if (r108 != null) goto L8;
        r105.bindNull(r107);
    L9:
        r107 = r107 + 1;
        goto L4
    L8:
        r105.bindString(r107, r108);
        goto L9
    L10:
        r105.bindLong(r104, r101);
        this.__db.assertNotSuspendingTransaction();
        Cursor r109 = DBUtil.query(this.__db, r105, false, null);
        ArrayList r110 = new ArrayList(r109.getCount());     // Catch: Throwable -> L30
    L12:
        if (r109.moveToNext() == false) goto L28;
        ResourceDataDelegate r111 = new ResourceDataDelegate();     // Catch: Throwable -> L30
        if (r109.isNull(0) == false) goto L17;
        String r112 = null;
    L18:
        r111.setResvalueFilePath(r112);     // Catch: Throwable -> L30
        if (r109.isNull(1) == false) goto L21;
        String r113 = null;
    L22:
        r111.setObj_token(r113);     // Catch: Throwable -> L30
        r111.setId(r109.getInt(2));     // Catch: Throwable -> L30
        if (r109.isNull(3) == false) goto L25;
        Long r114 = null;
    L26:
        r111.setAccessTime(r114);     // Catch: Throwable -> L30
        r110.add(r111);     // Catch: Throwable -> L30
        goto L12
    L25:
        r114 = Long.valueOf(r109.getLong(3));     // Catch: Throwable -> L30
        goto L26
    L21:
        r113 = r109.getString(1);     // Catch: Throwable -> L30
        goto L22
    L17:
        r112 = r109.getString(0);     // Catch: Throwable -> L30
        goto L18
    L28:
        r109.close();
        r105.release();
        return r110;
    L30:
        th = move-exception;
        r109.close();
        r105.release();
        throw th;
    }

    @Override // com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceDataDao
    public List<ResourceDataDelegate> loadReourceDelegate(String r100, String r101) {
        RoomSQLiteQuery r102 = RoomSQLiteQuery.acquire("SELECT id, resvalue_filepath FROM ResourceData WHERE obj_token=? and reskey= ?", 2);
        if (r100 != null) goto L5;
        r102.bindNull(1);
    L6:
        if (r101 != null) goto L8;
        r102.bindNull(2);
    L9:
        this.__db.assertNotSuspendingTransaction();
        Cursor r103 = DBUtil.query(this.__db, r102, false, null);
        ArrayList r104 = new ArrayList(r103.getCount());     // Catch: Throwable -> L21
    L11:
        if (r103.moveToNext() == false) goto L19;
        ResourceDataDelegate r105 = new ResourceDataDelegate();     // Catch: Throwable -> L21
        r105.setId(r103.getInt(0));     // Catch: Throwable -> L21
        if (r103.isNull(1) == false) goto L16;
        String r106 = null;
    L17:
        r105.setResvalueFilePath(r106);     // Catch: Throwable -> L21
        r104.add(r105);     // Catch: Throwable -> L21
        goto L11
    L16:
        r106 = r103.getString(1);     // Catch: Throwable -> L21
        goto L17
    L19:
        r103.close();
        r102.release();
        return r104;
    L21:
        th = move-exception;
        r103.close();
        r102.release();
        throw th;
    L8:
        r102.bindString(2, r101);
        goto L9
    L5:
        r102.bindString(1, r100);
        goto L6
    }

    @Override // com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceDataDao
    public List<ResourceDataDelegate> loadResourceDataByDocToken(String r100, long r101) {
        RoomSQLiteQuery r102 = RoomSQLiteQuery.acquire("SELECT resvalue_filepath,id FROM ResourceData WHERE obj_token= ? AND (category IS NULL OR (category IS NOT NULL AND access_time<= ?))", 2);
        if (r100 != null) goto L5;
        r102.bindNull(1);
    L6:
        r102.bindLong(2, r101);
        this.__db.assertNotSuspendingTransaction();
        Cursor r103 = DBUtil.query(this.__db, r102, false, null);
        ArrayList r104 = new ArrayList(r103.getCount());     // Catch: Throwable -> L18
    L8:
        if (r103.moveToNext() == false) goto L16;
        ResourceDataDelegate r105 = new ResourceDataDelegate();     // Catch: Throwable -> L18
        if (r103.isNull(0) == false) goto L13;
        String r106 = null;
    L14:
        r105.setResvalueFilePath(r106);     // Catch: Throwable -> L18
        r105.setId(r103.getInt(1));     // Catch: Throwable -> L18
        r104.add(r105);     // Catch: Throwable -> L18
        goto L8
    L13:
        r106 = r103.getString(0);     // Catch: Throwable -> L18
        goto L14
    L16:
        r103.close();
        r102.release();
        return r104;
    L18:
        th = move-exception;
        r103.close();
        r102.release();
        throw th;
    L5:
        r102.bindString(1, r100);
        goto L6
    }

    @Override // com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceDataDao
    public ResourceData loadResourceDataBySync(String r210, boolean r211) {
        RoomSQLiteQuery r100 = RoomSQLiteQuery.acquire("SELECT * FROM ResourceData WHERE isNeedSync= ? and obj_token= ?", 2);
        r100.bindLong(1, r211 ? 1 : 0);
        if (r210 != null) goto L5;
        r100.bindNull(2);
    L6:
        this.__db.assertNotSuspendingTransaction();
        Cursor r101 = DBUtil.query(this.__db, r100, false, null);
        int r102 = CursorUtil.getColumnIndexOrThrow(r101, "id");     // Catch: Throwable -> L82
        int r103 = CursorUtil.getColumnIndexOrThrow(r101, ResourceData.KEY_RES_KEY);     // Catch: Throwable -> L82
        int r104 = CursorUtil.getColumnIndexOrThrow(r101, ResourceData.KEY_RESOURCE_VALUE);     // Catch: Throwable -> L82
        int r105 = CursorUtil.getColumnIndexOrThrow(r101, ResourceData.KEY_RESOURCE_VALUE_FILE_PATH);     // Catch: Throwable -> L82
        int r110 = CursorUtil.getColumnIndexOrThrow(r101, "update_time");     // Catch: Throwable -> L82
        int r111 = CursorUtil.getColumnIndexOrThrow(r101, ResourceData.ACCESS_TIME);     // Catch: Throwable -> L82
        int r112 = CursorUtil.getColumnIndexOrThrow(r101, "isNeedSync");     // Catch: Throwable -> L82
        int r113 = CursorUtil.getColumnIndexOrThrow(r101, "config");     // Catch: Throwable -> L82
        int r114 = CursorUtil.getColumnIndexOrThrow(r101, "type");     // Catch: Throwable -> L82
        int r115 = CursorUtil.getColumnIndexOrThrow(r101, "token");     // Catch: Throwable -> L82
        int r106 = CursorUtil.getColumnIndexOrThrow(r101, "obj_token");     // Catch: Throwable -> L82
        int r107 = CursorUtil.getColumnIndexOrThrow(r101, "userToken");     // Catch: Throwable -> L82
        int r108 = CursorUtil.getColumnIndexOrThrow(r101, "tenantID");     // Catch: Throwable -> L82
        int r109 = CursorUtil.getColumnIndexOrThrow(r101, "url");     // Catch: Throwable -> L82
        RoomSQLiteQuery r116 = r100;
        int r117 = CursorUtil.getColumnIndexOrThrow(r101, ResourceData.KEY_SUBBLOCK_PRELOAD_STATUS);     // Catch: Throwable -> L80
        int r118 = CursorUtil.getColumnIndexOrThrow(r101, "page");     // Catch: Throwable -> L80
        int r119 = CursorUtil.getColumnIndexOrThrow(r101, ResourceData.KEY_TOTAL_PAGE);     // Catch: Throwable -> L80
        int r120 = CursorUtil.getColumnIndexOrThrow(r101, ResourceData.KEY_BATCH_NUM);     // Catch: Throwable -> L80
        int r121 = CursorUtil.getColumnIndexOrThrow(r101, ResourceData.KEY_LOAD_FROM);     // Catch: Throwable -> L80
        int r122 = CursorUtil.getColumnIndexOrThrow(r101, "category");     // Catch: Throwable -> L80
        if (r101.moveToFirst() == false) goto L77;
        ResourceData r123 = new ResourceData();     // Catch: Throwable -> L80
        r123.setId(r101.getInt(r102));     // Catch: Throwable -> L80
        if (r101.isNull(r103) == false) goto L14;
        String r124 = null;
    L15:
        r123.setReskey(r124);     // Catch: Throwable -> L80
        if (r101.isNull(r104) == false) goto L18;
        String r125 = null;
    L19:
        r123.setResvalue(r125);     // Catch: Throwable -> L80
        if (r101.isNull(r105) == false) goto L22;
        String r126 = null;
    L23:
        r123.setResvalueFilePath(r126);     // Catch: Throwable -> L80
        if (r101.isNull(r110) == false) goto L26;
        Long r127 = null;
    L27:
        r123.setUpdate_time(r127);     // Catch: Throwable -> L80
        if (r101.isNull(r111) == false) goto L30;
        Long r128 = null;
    L31:
        r123.setAccess_time(r128);     // Catch: Throwable -> L80
        if (r101.getInt(r112) == 0) goto L34;
        boolean r129 = true;
    L35:
        r123.setNeedSync(r129);     // Catch: Throwable -> L80
        if (r101.isNull(r113) == false) goto L38;
        String r130 = null;
    L39:
        r123.setConfig(r130);     // Catch: Throwable -> L80
        if (r101.isNull(r114) == false) goto L42;
        String r131 = null;
    L43:
        r123.setType(r131);     // Catch: Throwable -> L80
        if (r101.isNull(r115) == false) goto L46;
        String r132 = null;
    L47:
        r123.setToken(r132);     // Catch: Throwable -> L80
        if (r101.isNull(r106) == false) goto L50;
        String r133 = null;
    L51:
        r123.setObj_token(r133);     // Catch: Throwable -> L80
        if (r101.isNull(r107) == false) goto L54;
        String r134 = null;
    L55:
        r123.setUserToken(r134);     // Catch: Throwable -> L80
        if (r101.isNull(r108) == false) goto L58;
        String r135 = null;
    L59:
        r123.setTenantID(r135);     // Catch: Throwable -> L80
        if (r101.isNull(r109) == false) goto L62;
        String r136 = null;
    L63:
        r123.setUrl(r136);     // Catch: Throwable -> L80
        r123.setSubblock_preload_status(r101.getInt(r117));     // Catch: Throwable -> L80
        r123.setPage(r101.getInt(r118));     // Catch: Throwable -> L80
        r123.setTotalPage(r101.getInt(r119));     // Catch: Throwable -> L80
        if (r101.isNull(r120) == false) goto L66;
        String r137 = null;
    L67:
        r123.setBatchNum(r137);     // Catch: Throwable -> L80
        if (r101.isNull(r121) == false) goto L70;
        String r138 = null;
    L71:
        r123.setLoadFrom(r138);     // Catch: Throwable -> L80
        if (r101.isNull(r122) == false) goto L74;
        String r139 = null;
    L75:
        r123.setCategory(r139);     // Catch: Throwable -> L80
        ResourceData r140 = r123;
    L78:
        r101.close();
        r116.release();
        return r140;
    L74:
        r139 = r101.getString(r122);     // Catch: Throwable -> L80
        goto L75
    L70:
        r138 = r101.getString(r121);     // Catch: Throwable -> L80
        goto L71
    L66:
        r137 = r101.getString(r120);     // Catch: Throwable -> L80
        goto L67
    L62:
        r136 = r101.getString(r109);     // Catch: Throwable -> L80
        goto L63
    L58:
        r135 = r101.getString(r108);     // Catch: Throwable -> L80
        goto L59
    L54:
        r134 = r101.getString(r107);     // Catch: Throwable -> L80
        goto L55
    L50:
        r133 = r101.getString(r106);     // Catch: Throwable -> L80
        goto L51
    L46:
        r132 = r101.getString(r115);     // Catch: Throwable -> L80
        goto L47
    L42:
        r131 = r101.getString(r114);     // Catch: Throwable -> L80
        goto L43
    L38:
        r130 = r101.getString(r113);     // Catch: Throwable -> L80
        goto L39
    L34:
        r129 = false;
        goto L35
    L30:
        r128 = Long.valueOf(r101.getLong(r111));     // Catch: Throwable -> L80
        goto L31
    L26:
        r127 = Long.valueOf(r101.getLong(r110));     // Catch: Throwable -> L80
        goto L27
    L22:
        r126 = r101.getString(r105);     // Catch: Throwable -> L80
        goto L23
    L18:
        r125 = r101.getString(r104);     // Catch: Throwable -> L80
        goto L19
    L14:
        r124 = r101.getString(r103);     // Catch: Throwable -> L80
        goto L15
    L77:
        r140 = null;
    L80:
        th = th;
    L84:
        r101.close();
        r116.release();
        throw th;
    L82:
        th = th;
        r116 = r100;
        goto L84
    L5:
        r100.bindString(2, r210);
        goto L6
    }

    @Override // com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceDataDao
    public List<ResourceDataDelegate> loadResourceDataFullSyncUpTimeMills(long r100, int r110) {
        RoomSQLiteQuery r101 = RoomSQLiteQuery.acquire("SELECT id,resvalue_filepath,obj_token,resKey,id FROM ResourceData WHERE reskey LIKE '%CLIENT_VARS%' AND access_time<= ? AND isNeedSync=0 limit ?", 2);
        r101.bindLong(1, r100);
        r101.bindLong(2, r110);
        this.__db.assertNotSuspendingTransaction();
        Cursor r102 = DBUtil.query(this.__db, r101, false, null);
        ArrayList r103 = new ArrayList(r102.getCount());     // Catch: Throwable -> L22
    L4:
        if (r102.moveToNext() == false) goto L20;
        ResourceDataDelegate r104 = new ResourceDataDelegate();     // Catch: Throwable -> L22
        r104.setId(r102.getInt(0));     // Catch: Throwable -> L22
        if (r102.isNull(1) == false) goto L9;
        String r105 = null;
    L10:
        r104.setResvalueFilePath(r105);     // Catch: Throwable -> L22
        if (r102.isNull(2) == false) goto L13;
        String r106 = null;
    L14:
        r104.setObj_token(r106);     // Catch: Throwable -> L22
        if (r102.isNull(3) == false) goto L17;
        String r107 = null;
    L18:
        r104.setReskey(r107);     // Catch: Throwable -> L22
        r104.setId(r102.getInt(0));     // Catch: Throwable -> L22
        r103.add(r104);     // Catch: Throwable -> L22
        goto L4
    L17:
        r107 = r102.getString(3);     // Catch: Throwable -> L22
        goto L18
    L13:
        r106 = r102.getString(2);     // Catch: Throwable -> L22
        goto L14
    L9:
        r105 = r102.getString(1);     // Catch: Throwable -> L22
        goto L10
    L20:
        r102.close();
        r101.release();
        return r103;
    L22:
        th = move-exception;
        r102.close();
        r101.release();
        throw th;
    }

    @Override // com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceDataDao
    public List<String> loadTokensBySync(boolean r100, long r101) {
        RoomSQLiteQuery r102 = RoomSQLiteQuery.acquire("SELECT DISTINCT obj_token FROM ResourceData WHERE isNeedSync= ? OR (category IS NOT NULL AND access_time> ?)", 2);
        r102.bindLong(1, r100 ? 1 : 0);
        r102.bindLong(2, r101);
        this.__db.assertNotSuspendingTransaction();
        Cursor r103 = DBUtil.query(this.__db, r102, false, null);
        ArrayList r104 = new ArrayList(r103.getCount());     // Catch: Throwable -> L14
    L4:
        if (r103.moveToNext() == false) goto L12;
        if (r103.isNull(0) == false) goto L9;
        String r105 = null;
    L10:
        r104.add(r105);     // Catch: Throwable -> L14
        goto L4
    L9:
        r105 = r103.getString(0);     // Catch: Throwable -> L14
        goto L10
    L12:
        r103.close();
        r102.release();
        return r104;
    L14:
        th = move-exception;
        r103.close();
        r102.release();
        throw th;
    }

    @Override // com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceDataDao
    public int deleteResourceData(String r100, String r101, long r102) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r103 = this.__preparedStmtOfDeleteResourceData_1.acquire();
        if (r100 != null) goto L5;
        r103.bindNull(1);
    L7:
        if (r101 != null) goto L9;
        r103.bindNull(2);
    L10:
        r103.bindLong(3, r102);
        this.__db.beginTransaction();
        int r104 = r103.executeUpdateDelete();     // Catch: Throwable -> L14
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L14
        this.__db.endTransaction();
        this.__preparedStmtOfDeleteResourceData_1.release(r103);
        return r104;
    L14:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfDeleteResourceData_1.release(r103);
        throw th;
    L9:
        r103.bindString(2, r101);
        goto L10
    L5:
        r103.bindString(1, r100);
        goto L7
    }

    @Override // com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceDataDao
    public ResourceData loadResourceData(String r210, String r211, int r212) {
        RoomSQLiteQuery r100 = RoomSQLiteQuery.acquire("SELECT * FROM ResourceData WHERE obj_token=? and reskey= ? and page = ?", 3);
        if (r210 != null) goto L5;
        r100.bindNull(1);
    L7:
        if (r211 != null) goto L9;
        r100.bindNull(2);
    L10:
        r100.bindLong(3, r212);
        this.__db.assertNotSuspendingTransaction();
        Cursor r101 = DBUtil.query(this.__db, r100, false, null);
        int r102 = CursorUtil.getColumnIndexOrThrow(r101, "id");     // Catch: Throwable -> L86
        int r103 = CursorUtil.getColumnIndexOrThrow(r101, ResourceData.KEY_RES_KEY);     // Catch: Throwable -> L86
        int r104 = CursorUtil.getColumnIndexOrThrow(r101, ResourceData.KEY_RESOURCE_VALUE);     // Catch: Throwable -> L86
        int r105 = CursorUtil.getColumnIndexOrThrow(r101, ResourceData.KEY_RESOURCE_VALUE_FILE_PATH);     // Catch: Throwable -> L86
        int r110 = CursorUtil.getColumnIndexOrThrow(r101, "update_time");     // Catch: Throwable -> L86
        int r111 = CursorUtil.getColumnIndexOrThrow(r101, ResourceData.ACCESS_TIME);     // Catch: Throwable -> L86
        int r112 = CursorUtil.getColumnIndexOrThrow(r101, "isNeedSync");     // Catch: Throwable -> L86
        int r113 = CursorUtil.getColumnIndexOrThrow(r101, "config");     // Catch: Throwable -> L86
        int r114 = CursorUtil.getColumnIndexOrThrow(r101, "type");     // Catch: Throwable -> L86
        int r115 = CursorUtil.getColumnIndexOrThrow(r101, "token");     // Catch: Throwable -> L86
        int r106 = CursorUtil.getColumnIndexOrThrow(r101, "obj_token");     // Catch: Throwable -> L86
        int r107 = CursorUtil.getColumnIndexOrThrow(r101, "userToken");     // Catch: Throwable -> L86
        int r108 = CursorUtil.getColumnIndexOrThrow(r101, "tenantID");     // Catch: Throwable -> L86
        int r109 = CursorUtil.getColumnIndexOrThrow(r101, "url");     // Catch: Throwable -> L86
        RoomSQLiteQuery r116 = r100;
        int r117 = CursorUtil.getColumnIndexOrThrow(r101, ResourceData.KEY_SUBBLOCK_PRELOAD_STATUS);     // Catch: Throwable -> L84
        int r118 = CursorUtil.getColumnIndexOrThrow(r101, "page");     // Catch: Throwable -> L84
        int r119 = CursorUtil.getColumnIndexOrThrow(r101, ResourceData.KEY_TOTAL_PAGE);     // Catch: Throwable -> L84
        int r120 = CursorUtil.getColumnIndexOrThrow(r101, ResourceData.KEY_BATCH_NUM);     // Catch: Throwable -> L84
        int r121 = CursorUtil.getColumnIndexOrThrow(r101, ResourceData.KEY_LOAD_FROM);     // Catch: Throwable -> L84
        int r122 = CursorUtil.getColumnIndexOrThrow(r101, "category");     // Catch: Throwable -> L84
        if (r101.moveToFirst() == false) goto L81;
        ResourceData r123 = new ResourceData();     // Catch: Throwable -> L84
        r123.setId(r101.getInt(r102));     // Catch: Throwable -> L84
        if (r101.isNull(r103) == false) goto L18;
        String r124 = null;
    L19:
        r123.setReskey(r124);     // Catch: Throwable -> L84
        if (r101.isNull(r104) == false) goto L22;
        String r125 = null;
    L23:
        r123.setResvalue(r125);     // Catch: Throwable -> L84
        if (r101.isNull(r105) == false) goto L26;
        String r126 = null;
    L27:
        r123.setResvalueFilePath(r126);     // Catch: Throwable -> L84
        if (r101.isNull(r110) == false) goto L30;
        Long r127 = null;
    L31:
        r123.setUpdate_time(r127);     // Catch: Throwable -> L84
        if (r101.isNull(r111) == false) goto L34;
        Long r128 = null;
    L35:
        r123.setAccess_time(r128);     // Catch: Throwable -> L84
        if (r101.getInt(r112) == 0) goto L38;
        boolean r129 = true;
    L39:
        r123.setNeedSync(r129);     // Catch: Throwable -> L84
        if (r101.isNull(r113) == false) goto L42;
        String r130 = null;
    L43:
        r123.setConfig(r130);     // Catch: Throwable -> L84
        if (r101.isNull(r114) == false) goto L46;
        String r131 = null;
    L47:
        r123.setType(r131);     // Catch: Throwable -> L84
        if (r101.isNull(r115) == false) goto L50;
        String r132 = null;
    L51:
        r123.setToken(r132);     // Catch: Throwable -> L84
        if (r101.isNull(r106) == false) goto L54;
        String r133 = null;
    L55:
        r123.setObj_token(r133);     // Catch: Throwable -> L84
        if (r101.isNull(r107) == false) goto L58;
        String r134 = null;
    L59:
        r123.setUserToken(r134);     // Catch: Throwable -> L84
        if (r101.isNull(r108) == false) goto L62;
        String r135 = null;
    L63:
        r123.setTenantID(r135);     // Catch: Throwable -> L84
        if (r101.isNull(r109) == false) goto L66;
        String r136 = null;
    L67:
        r123.setUrl(r136);     // Catch: Throwable -> L84
        r123.setSubblock_preload_status(r101.getInt(r117));     // Catch: Throwable -> L84
        r123.setPage(r101.getInt(r118));     // Catch: Throwable -> L84
        r123.setTotalPage(r101.getInt(r119));     // Catch: Throwable -> L84
        if (r101.isNull(r120) == false) goto L70;
        String r137 = null;
    L71:
        r123.setBatchNum(r137);     // Catch: Throwable -> L84
        if (r101.isNull(r121) == false) goto L74;
        String r138 = null;
    L75:
        r123.setLoadFrom(r138);     // Catch: Throwable -> L84
        if (r101.isNull(r122) == false) goto L78;
        String r139 = null;
    L79:
        r123.setCategory(r139);     // Catch: Throwable -> L84
        ResourceData r140 = r123;
    L82:
        r101.close();
        r116.release();
        return r140;
    L78:
        r139 = r101.getString(r122);     // Catch: Throwable -> L84
        goto L79
    L74:
        r138 = r101.getString(r121);     // Catch: Throwable -> L84
        goto L75
    L70:
        r137 = r101.getString(r120);     // Catch: Throwable -> L84
        goto L71
    L66:
        r136 = r101.getString(r109);     // Catch: Throwable -> L84
        goto L67
    L62:
        r135 = r101.getString(r108);     // Catch: Throwable -> L84
        goto L63
    L58:
        r134 = r101.getString(r107);     // Catch: Throwable -> L84
        goto L59
    L54:
        r133 = r101.getString(r106);     // Catch: Throwable -> L84
        goto L55
    L50:
        r132 = r101.getString(r115);     // Catch: Throwable -> L84
        goto L51
    L46:
        r131 = r101.getString(r114);     // Catch: Throwable -> L84
        goto L47
    L42:
        r130 = r101.getString(r113);     // Catch: Throwable -> L84
        goto L43
    L38:
        r129 = false;
        goto L39
    L34:
        r128 = Long.valueOf(r101.getLong(r111));     // Catch: Throwable -> L84
        goto L35
    L30:
        r127 = Long.valueOf(r101.getLong(r110));     // Catch: Throwable -> L84
        goto L31
    L26:
        r126 = r101.getString(r105);     // Catch: Throwable -> L84
        goto L27
    L22:
        r125 = r101.getString(r104);     // Catch: Throwable -> L84
        goto L23
    L18:
        r124 = r101.getString(r103);     // Catch: Throwable -> L84
        goto L19
    L81:
        r140 = null;
    L84:
        th = th;
    L88:
        r101.close();
        r116.release();
        throw th;
    L86:
        th = th;
        r116 = r100;
        goto L88
    L9:
        r100.bindString(2, r211);
        goto L10
    L5:
        r100.bindString(1, r210);
        goto L7
    }

    @Override // com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceDataDao
    public ResourceData loadResourceDataByCategory(String r210, String r211, int r212) {
        RoomSQLiteQuery r100 = RoomSQLiteQuery.acquire("SELECT * FROM ResourceData WHERE obj_token=? and category= ? and page = ?", 3);
        if (r211 != null) goto L5;
        r100.bindNull(1);
    L7:
        if (r210 != null) goto L9;
        r100.bindNull(2);
    L10:
        r100.bindLong(3, r212);
        this.__db.assertNotSuspendingTransaction();
        Cursor r101 = DBUtil.query(this.__db, r100, false, null);
        int r102 = CursorUtil.getColumnIndexOrThrow(r101, "id");     // Catch: Throwable -> L86
        int r103 = CursorUtil.getColumnIndexOrThrow(r101, ResourceData.KEY_RES_KEY);     // Catch: Throwable -> L86
        int r104 = CursorUtil.getColumnIndexOrThrow(r101, ResourceData.KEY_RESOURCE_VALUE);     // Catch: Throwable -> L86
        int r105 = CursorUtil.getColumnIndexOrThrow(r101, ResourceData.KEY_RESOURCE_VALUE_FILE_PATH);     // Catch: Throwable -> L86
        int r110 = CursorUtil.getColumnIndexOrThrow(r101, "update_time");     // Catch: Throwable -> L86
        int r111 = CursorUtil.getColumnIndexOrThrow(r101, ResourceData.ACCESS_TIME);     // Catch: Throwable -> L86
        int r112 = CursorUtil.getColumnIndexOrThrow(r101, "isNeedSync");     // Catch: Throwable -> L86
        int r113 = CursorUtil.getColumnIndexOrThrow(r101, "config");     // Catch: Throwable -> L86
        int r114 = CursorUtil.getColumnIndexOrThrow(r101, "type");     // Catch: Throwable -> L86
        int r115 = CursorUtil.getColumnIndexOrThrow(r101, "token");     // Catch: Throwable -> L86
        int r106 = CursorUtil.getColumnIndexOrThrow(r101, "obj_token");     // Catch: Throwable -> L86
        int r107 = CursorUtil.getColumnIndexOrThrow(r101, "userToken");     // Catch: Throwable -> L86
        int r108 = CursorUtil.getColumnIndexOrThrow(r101, "tenantID");     // Catch: Throwable -> L86
        int r109 = CursorUtil.getColumnIndexOrThrow(r101, "url");     // Catch: Throwable -> L86
        RoomSQLiteQuery r116 = r100;
        int r117 = CursorUtil.getColumnIndexOrThrow(r101, ResourceData.KEY_SUBBLOCK_PRELOAD_STATUS);     // Catch: Throwable -> L84
        int r118 = CursorUtil.getColumnIndexOrThrow(r101, "page");     // Catch: Throwable -> L84
        int r119 = CursorUtil.getColumnIndexOrThrow(r101, ResourceData.KEY_TOTAL_PAGE);     // Catch: Throwable -> L84
        int r120 = CursorUtil.getColumnIndexOrThrow(r101, ResourceData.KEY_BATCH_NUM);     // Catch: Throwable -> L84
        int r121 = CursorUtil.getColumnIndexOrThrow(r101, ResourceData.KEY_LOAD_FROM);     // Catch: Throwable -> L84
        int r122 = CursorUtil.getColumnIndexOrThrow(r101, "category");     // Catch: Throwable -> L84
        if (r101.moveToFirst() == false) goto L81;
        ResourceData r123 = new ResourceData();     // Catch: Throwable -> L84
        r123.setId(r101.getInt(r102));     // Catch: Throwable -> L84
        if (r101.isNull(r103) == false) goto L18;
        String r124 = null;
    L19:
        r123.setReskey(r124);     // Catch: Throwable -> L84
        if (r101.isNull(r104) == false) goto L22;
        String r125 = null;
    L23:
        r123.setResvalue(r125);     // Catch: Throwable -> L84
        if (r101.isNull(r105) == false) goto L26;
        String r126 = null;
    L27:
        r123.setResvalueFilePath(r126);     // Catch: Throwable -> L84
        if (r101.isNull(r110) == false) goto L30;
        Long r127 = null;
    L31:
        r123.setUpdate_time(r127);     // Catch: Throwable -> L84
        if (r101.isNull(r111) == false) goto L34;
        Long r128 = null;
    L35:
        r123.setAccess_time(r128);     // Catch: Throwable -> L84
        if (r101.getInt(r112) == 0) goto L38;
        boolean r129 = true;
    L39:
        r123.setNeedSync(r129);     // Catch: Throwable -> L84
        if (r101.isNull(r113) == false) goto L42;
        String r130 = null;
    L43:
        r123.setConfig(r130);     // Catch: Throwable -> L84
        if (r101.isNull(r114) == false) goto L46;
        String r131 = null;
    L47:
        r123.setType(r131);     // Catch: Throwable -> L84
        if (r101.isNull(r115) == false) goto L50;
        String r132 = null;
    L51:
        r123.setToken(r132);     // Catch: Throwable -> L84
        if (r101.isNull(r106) == false) goto L54;
        String r133 = null;
    L55:
        r123.setObj_token(r133);     // Catch: Throwable -> L84
        if (r101.isNull(r107) == false) goto L58;
        String r134 = null;
    L59:
        r123.setUserToken(r134);     // Catch: Throwable -> L84
        if (r101.isNull(r108) == false) goto L62;
        String r135 = null;
    L63:
        r123.setTenantID(r135);     // Catch: Throwable -> L84
        if (r101.isNull(r109) == false) goto L66;
        String r136 = null;
    L67:
        r123.setUrl(r136);     // Catch: Throwable -> L84
        r123.setSubblock_preload_status(r101.getInt(r117));     // Catch: Throwable -> L84
        r123.setPage(r101.getInt(r118));     // Catch: Throwable -> L84
        r123.setTotalPage(r101.getInt(r119));     // Catch: Throwable -> L84
        if (r101.isNull(r120) == false) goto L70;
        String r137 = null;
    L71:
        r123.setBatchNum(r137);     // Catch: Throwable -> L84
        if (r101.isNull(r121) == false) goto L74;
        String r138 = null;
    L75:
        r123.setLoadFrom(r138);     // Catch: Throwable -> L84
        if (r101.isNull(r122) == false) goto L78;
        String r139 = null;
    L79:
        r123.setCategory(r139);     // Catch: Throwable -> L84
        ResourceData r140 = r123;
    L82:
        r101.close();
        r116.release();
        return r140;
    L78:
        r139 = r101.getString(r122);     // Catch: Throwable -> L84
        goto L79
    L74:
        r138 = r101.getString(r121);     // Catch: Throwable -> L84
        goto L75
    L70:
        r137 = r101.getString(r120);     // Catch: Throwable -> L84
        goto L71
    L66:
        r136 = r101.getString(r109);     // Catch: Throwable -> L84
        goto L67
    L62:
        r135 = r101.getString(r108);     // Catch: Throwable -> L84
        goto L63
    L58:
        r134 = r101.getString(r107);     // Catch: Throwable -> L84
        goto L59
    L54:
        r133 = r101.getString(r106);     // Catch: Throwable -> L84
        goto L55
    L50:
        r132 = r101.getString(r115);     // Catch: Throwable -> L84
        goto L51
    L46:
        r131 = r101.getString(r114);     // Catch: Throwable -> L84
        goto L47
    L42:
        r130 = r101.getString(r113);     // Catch: Throwable -> L84
        goto L43
    L38:
        r129 = false;
        goto L39
    L34:
        r128 = Long.valueOf(r101.getLong(r111));     // Catch: Throwable -> L84
        goto L35
    L30:
        r127 = Long.valueOf(r101.getLong(r110));     // Catch: Throwable -> L84
        goto L31
    L26:
        r126 = r101.getString(r105);     // Catch: Throwable -> L84
        goto L27
    L22:
        r125 = r101.getString(r104);     // Catch: Throwable -> L84
        goto L23
    L18:
        r124 = r101.getString(r103);     // Catch: Throwable -> L84
        goto L19
    L81:
        r140 = null;
    L84:
        th = th;
    L88:
        r101.close();
        r116.release();
        throw th;
    L86:
        th = th;
        r116 = r100;
        goto L88
    L9:
        r100.bindString(2, r210);
        goto L10
    L5:
        r100.bindString(1, r211);
        goto L7
    }

    @Override // com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceDataDao
    public List<ResourceDataDelegate> loadResourceDataFullSyncUpTimeMillsV2(long r100, List<String> r101, int r110) {
        StringBuilder r102 = StringUtil.newStringBuilder();
        r102.append("SELECT obj_token,resvalue_filepath,id,access_time FROM ResourceData WHERE access_time<= ");
        r102.append("?");
        r102.append(" AND obj_token NOT IN(");
        int r103 = r101.size();
        StringUtil.appendPlaceholders(r102, r103);
        r102.append(") limit ");
        r102.append("?");
        int r104 = r103 + 2;
        RoomSQLiteQuery r105 = RoomSQLiteQuery.acquire(r102.toString(), r104);
        r105.bindLong(1, r100);
        Iterator<String> r106 = r101.iterator();
        int r107 = 2;
    L4:
        if (r106.hasNext() == false) goto L10;
        String r108 = r106.next();
        if (r108 != null) goto L8;
        r105.bindNull(r107);
    L9:
        r107 = r107 + 1;
        goto L4
    L8:
        r105.bindString(r107, r108);
        goto L9
    L10:
        r105.bindLong(r104, r110);
        this.__db.assertNotSuspendingTransaction();
        Cursor r109 = DBUtil.query(this.__db, r105, false, null);
        ArrayList r111 = new ArrayList(r109.getCount());     // Catch: Throwable -> L30
    L12:
        if (r109.moveToNext() == false) goto L28;
        ResourceDataDelegate r112 = new ResourceDataDelegate();     // Catch: Throwable -> L30
        if (r109.isNull(0) == false) goto L17;
        String r113 = null;
    L18:
        r112.setObj_token(r113);     // Catch: Throwable -> L30
        if (r109.isNull(1) == false) goto L21;
        String r114 = null;
    L22:
        r112.setResvalueFilePath(r114);     // Catch: Throwable -> L30
        r112.setId(r109.getInt(2));     // Catch: Throwable -> L30
        if (r109.isNull(3) == false) goto L25;
        Long r115 = null;
    L26:
        r112.setAccessTime(r115);     // Catch: Throwable -> L30
        r111.add(r112);     // Catch: Throwable -> L30
        goto L12
    L25:
        r115 = Long.valueOf(r109.getLong(3));     // Catch: Throwable -> L30
        goto L26
    L21:
        r114 = r109.getString(1);     // Catch: Throwable -> L30
        goto L22
    L17:
        r113 = r109.getString(0);     // Catch: Throwable -> L30
        goto L18
    L28:
        r109.close();
        r105.release();
        return r111;
    L30:
        th = move-exception;
        r109.close();
        r105.release();
        throw th;
    }

    @Override // com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceDataDao
    public ResourceDataSubInfo loadSubInfo(String r100, String r101, int r102) {
        RoomSQLiteQuery r103 = RoomSQLiteQuery.acquire("SELECT id,subblock_preload_status,page,total_page,resvalue_filepath FROM ResourceData WHERE obj_token = ? AND reskey = ? AND page = ?", 3);
        if (r101 != null) goto L5;
        r103.bindNull(1);
    L7:
        if (r100 != null) goto L9;
        r103.bindNull(2);
    L10:
        r103.bindLong(3, r102);
        this.__db.assertNotSuspendingTransaction();
        ResourceDataSubInfo r104 = null;
        Cursor r105 = DBUtil.query(this.__db, r103, false, null);
    L16:
        th = move-exception;
        r105.close();
        r103.release();
        throw th;
    L12:
        if (r105.moveToFirst() == false) goto L14;
        r104 = new ResourceDataSubInfo();     // Catch: Throwable -> L16
        r104.setId(r105.getInt(0));     // Catch: Throwable -> L16
        r104.setSubblock_preload_status(r105.getInt(1));     // Catch: Throwable -> L16
        r104.setPage(r105.getInt(2));     // Catch: Throwable -> L16
        r104.setTotalPage(r105.getInt(3));     // Catch: Throwable -> L16
    L14:
        r105.close();
        r103.release();
        return r104;
    L9:
        r103.bindString(2, r100);
        goto L10
    L5:
        r103.bindString(1, r101);
        goto L7
    }

    @Override // com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceDataDao
    public int updateResourceDataToken(String r100, String r101, List<Integer> r102) {
        this.__db.assertNotSuspendingTransaction();
        StringBuilder r103 = StringUtil.newStringBuilder();
        r103.append("UPDATE ResourceData SET obj_token = ");
        r103.append("?");
        r103.append(", token = ");
        r103.append("?");
        r103.append(" WHERE id in (");
        StringUtil.appendPlaceholders(r103, r102.size());
        r103.append(")");
        SupportSQLiteStatement r104 = this.__db.compileStatement(r103.toString());
        if (r100 != null) goto L5;
        r104.bindNull(1);
    L7:
        if (r101 != null) goto L9;
        r104.bindNull(2);
    L10:
        Iterator<Integer> r105 = r102.iterator();
        int r106 = 3;
    L12:
        if (r105.hasNext() == false) goto L18;
        Integer r107 = r105.next();
        if (r107 != null) goto L16;
        r104.bindNull(r106);
    L17:
        r106 = r106 + 1;
        goto L12
    L16:
        r104.bindLong(r106, r107.intValue());
        goto L17
    L18:
        this.__db.beginTransaction();
        int r108 = r104.executeUpdateDelete();     // Catch: Throwable -> L22
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L22
        this.__db.endTransaction();
        return r108;
    L22:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    L9:
        r104.bindString(2, r101);
        goto L10
    L5:
        r104.bindString(1, r100);
        goto L7
    }

    @Override // com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceDataDao
    public List<String> loadDocxWithClientVarsWithoutSSR(int r100, String r101, String r102, long r103, int r104) {
        RoomSQLiteQuery r105 = RoomSQLiteQuery.acquire("SELECT A.obj_token FROM (SELECT DISTINCT obj_token FROM ResourceData WHERE reskey = ? AND type IS NOT 'doc' AND update_time>= ? order by update_time desc limit ?) AS A LEFT OUTER JOIN (SELECT DISTINCT obj_token FROM ResourceData WHERE reskey = ? AND resvalue IS NOT NULL) AS B on A.obj_token = B.obj_token WHERE B.obj_token IS NULL limit ?", 5);
        if (r101 != null) goto L5;
        r105.bindNull(1);
    L6:
        r105.bindLong(2, r103);
        r105.bindLong(3, r100);
        if (r102 != null) goto L9;
        r105.bindNull(4);
    L10:
        r105.bindLong(5, r104);
        this.__db.assertNotSuspendingTransaction();
        Cursor r106 = DBUtil.query(this.__db, r105, false, null);
        ArrayList r107 = new ArrayList(r106.getCount());     // Catch: Throwable -> L22
    L12:
        if (r106.moveToNext() == false) goto L20;
        if (r106.isNull(0) == false) goto L17;
        String r108 = null;
    L18:
        r107.add(r108);     // Catch: Throwable -> L22
        goto L12
    L17:
        r108 = r106.getString(0);     // Catch: Throwable -> L22
        goto L18
    L20:
        r106.close();
        r105.release();
        return r107;
    L22:
        th = move-exception;
        r106.close();
        r105.release();
        throw th;
    L9:
        r105.bindString(4, r102);
        goto L10
    L5:
        r105.bindString(1, r101);
        goto L6
    }
}
