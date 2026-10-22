package com.bytedance.ee.docsdk.impl.document.plugins.offline.storage;

/* JADX INFO: loaded from: classes18.dex */
public class ResourceData {
    public static final String ACCESS_TIME = "access_time";
    public static final int DOC_PRIMARY_DATA = 1;
    public static final String KEY_BATCH_NUM = "batch_num";
    public static final String KEY_CATEGORY = "category";
    public static final String KEY_ID = "id";
    public static final String KEY_LOAD_FROM = "load_from";
    public static final String KEY_OBJ_TOKEN = "obj_token";
    public static final String KEY_PAGE = "page";
    public static final String KEY_RESOURCE_VALUE = "resvalue";
    public static final String KEY_RESOURCE_VALUE_FILE_PATH = "resvalue_filepath";
    public static final String KEY_RES_KEY = "reskey";
    public static final String KEY_SUBBLOCK_PRELOAD_STATUS = "subblock_preload_status";
    public static final String KEY_TOKEN = "token";
    public static final String KEY_TOTAL_PAGE = "total_page";
    public static final String KEY_TYPE = "type";
    public static final String KEY_URL = "url";
    public static final String TABLE_NAME = "ResourceData";
    private Long access_time;
    private String batchNum;
    private String category;
    private String config;
    private int dataType;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private int f242635id;
    private boolean isNeedSync;
    private String loadFrom;
    private String obj_token;
    private int page;
    private String reskey;
    private String resvalue;
    private String resvalueFilePath;
    private int subblock_preload_status;
    private String tenantID;
    private String token;
    private int totalPage;
    private String type;
    private Long update_time;
    private String url;
    private String userToken;

    public boolean hasNotPaged() {
        if (this.totalPage == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean hasPaged() {
        if (this.totalPage > 1) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean isFirstPage() {
        if (this.page != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isLastPage() {
        if ((this.page + 1) == this.totalPage) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean isPrimaryKeyData() {
        if (this.dataType == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public String toString() {
        return "ResourceData{id=" + this.f242635id + ", update_time=" + this.update_time + ", access_time=" + this.access_time + ", isNeedSync=" + this.isNeedSync + ", config='" + this.config + "', type='" + this.type + "', dataType='" + this.dataType + "', subblock_preload_status='" + this.subblock_preload_status + "', page=" + this.page + ", totalPage=" + this.totalPage + ", batchNum=" + this.batchNum + ", category=" + this.category + '}';
    }

    public ResourceData() {
        this.update_time = Long.valueOf(System.currentTimeMillis());
        this.access_time = Long.valueOf(System.currentTimeMillis());
        this.isNeedSync = false;
        this.page = 0;
        this.totalPage = 1;
    }

    public Long getAccess_time() {
        return this.access_time;
    }

    public String getBatchNum() {
        return this.batchNum;
    }

    public String getCategory() {
        return this.category;
    }

    public String getConfig() {
        return this.config;
    }

    public int getDataType() {
        return this.dataType;
    }

    public int getId() {
        return this.f242635id;
    }

    public String getLoadFrom() {
        return this.loadFrom;
    }

    public String getObj_token() {
        return this.obj_token;
    }

    public int getPage() {
        return this.page;
    }

    public String getReskey() {
        return this.reskey;
    }

    public String getResvalue() {
        return this.resvalue;
    }

    public String getResvalueFilePath() {
        return this.resvalueFilePath;
    }

    public int getSubblock_preload_status() {
        return this.subblock_preload_status;
    }

    public String getTenantID() {
        return this.tenantID;
    }

    public String getToken() {
        return this.token;
    }

    public int getTotalPage() {
        return this.totalPage;
    }

    public String getType() {
        return this.type;
    }

    public Long getUpdate_time() {
        return this.update_time;
    }

    public String getUrl() {
        return this.url;
    }

    public String getUserToken() {
        return this.userToken;
    }

    public boolean isNeedSync() {
        return this.isNeedSync;
    }

    public ResourceData(ResourceData r100) {
        this.update_time = Long.valueOf(System.currentTimeMillis());
        this.access_time = Long.valueOf(System.currentTimeMillis());
        this.isNeedSync = false;
        this.page = 0;
        this.totalPage = 1;
        this.f242635id = r100.f242635id;
        this.reskey = r100.reskey;
        this.resvalue = r100.resvalue;
        this.resvalueFilePath = r100.resvalueFilePath;
        this.update_time = r100.update_time;
        this.access_time = r100.access_time;
        this.isNeedSync = r100.isNeedSync;
        this.config = r100.config;
        this.type = r100.type;
        this.token = r100.token;
        this.obj_token = r100.obj_token;
        this.userToken = r100.userToken;
        this.tenantID = r100.tenantID;
        this.url = r100.url;
        this.dataType = r100.dataType;
        this.subblock_preload_status = r100.subblock_preload_status;
        this.page = r100.page;
        this.totalPage = r100.totalPage;
        this.batchNum = r100.batchNum;
        this.loadFrom = r100.loadFrom;
        this.category = r100.category;
    }

    public void setAccess_time(Long r100) {
        this.access_time = r100;
    }

    public void setBatchNum(String r100) {
        this.batchNum = r100;
    }

    public void setCategory(String r100) {
        this.category = r100;
    }

    public void setConfig(String r100) {
        this.config = r100;
    }

    public void setDataType(int r100) {
        this.dataType = r100;
    }

    public void setId(int r100) {
        this.f242635id = r100;
    }

    public void setLoadFrom(String r100) {
        this.loadFrom = r100;
    }

    public void setNeedSync(boolean r100) {
        this.isNeedSync = r100;
    }

    public void setObj_token(String r100) {
        this.obj_token = r100;
    }

    public void setPage(int r100) {
        this.page = r100;
    }

    public void setReskey(String r100) {
        this.reskey = r100;
    }

    public void setResvalue(String r100) {
        this.resvalue = r100;
    }

    public void setResvalueFilePath(String r100) {
        this.resvalueFilePath = r100;
    }

    public void setSubblock_preload_status(int r100) {
        this.subblock_preload_status = r100;
    }

    public void setTenantID(String r100) {
        this.tenantID = r100;
    }

    public void setToken(String r100) {
        this.token = r100;
    }

    public void setTotalPage(int r100) {
        this.totalPage = r100;
    }

    public void setType(String r100) {
        this.type = r100;
    }

    public void setUpdate_time(Long r100) {
        this.update_time = r100;
    }

    public void setUrl(String r100) {
        this.url = r100;
    }

    public void setUserToken(String r100) {
        this.userToken = r100;
    }

    public ResourceData(String r100, String r101) {
        this.update_time = Long.valueOf(System.currentTimeMillis());
        this.access_time = Long.valueOf(System.currentTimeMillis());
        this.isNeedSync = false;
        this.page = 0;
        this.totalPage = 1;
        this.reskey = r100;
        this.obj_token = r101;
    }

    public ResourceData(String r100, String r101, String r102) {
        this.update_time = Long.valueOf(System.currentTimeMillis());
        this.access_time = Long.valueOf(System.currentTimeMillis());
        this.isNeedSync = false;
        this.page = 0;
        this.totalPage = 1;
        this.reskey = r100;
        this.type = r101;
        this.resvalue = r102;
    }
}
