package com.bytedance.ee.docsdk.impl.document.plugins.offline.storage;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
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
    private int id;
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
        return "ResourceData{id=" + this.id + ", update_time=" + this.update_time + ", access_time=" + this.access_time + ", isNeedSync=" + this.isNeedSync + ", config='" + this.config + "', type='" + this.type + "', dataType='" + this.dataType + "', subblock_preload_status='" + this.subblock_preload_status + "', page=" + this.page + ", totalPage=" + this.totalPage + ", batchNum=" + this.batchNum + ", category=" + this.category + '}';
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
        return this.id;
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

    public ResourceData(ResourceData r3) {
        this.update_time = Long.valueOf(System.currentTimeMillis());
        this.access_time = Long.valueOf(System.currentTimeMillis());
        this.isNeedSync = false;
        this.page = 0;
        this.totalPage = 1;
        this.id = r3.id;
        this.reskey = r3.reskey;
        this.resvalue = r3.resvalue;
        this.resvalueFilePath = r3.resvalueFilePath;
        this.update_time = r3.update_time;
        this.access_time = r3.access_time;
        this.isNeedSync = r3.isNeedSync;
        this.config = r3.config;
        this.type = r3.type;
        this.token = r3.token;
        this.obj_token = r3.obj_token;
        this.userToken = r3.userToken;
        this.tenantID = r3.tenantID;
        this.url = r3.url;
        this.dataType = r3.dataType;
        this.subblock_preload_status = r3.subblock_preload_status;
        this.page = r3.page;
        this.totalPage = r3.totalPage;
        this.batchNum = r3.batchNum;
        this.loadFrom = r3.loadFrom;
        this.category = r3.category;
    }

    public void setAccess_time(Long r1) {
        this.access_time = r1;
    }

    public void setBatchNum(String r1) {
        this.batchNum = r1;
    }

    public void setCategory(String r1) {
        this.category = r1;
    }

    public void setConfig(String r1) {
        this.config = r1;
    }

    public void setDataType(int r1) {
        this.dataType = r1;
    }

    public void setId(int r1) {
        this.id = r1;
    }

    public void setLoadFrom(String r1) {
        this.loadFrom = r1;
    }

    public void setNeedSync(boolean r1) {
        this.isNeedSync = r1;
    }

    public void setObj_token(String r1) {
        this.obj_token = r1;
    }

    public void setPage(int r1) {
        this.page = r1;
    }

    public void setReskey(String r1) {
        this.reskey = r1;
    }

    public void setResvalue(String r1) {
        this.resvalue = r1;
    }

    public void setResvalueFilePath(String r1) {
        this.resvalueFilePath = r1;
    }

    public void setSubblock_preload_status(int r1) {
        this.subblock_preload_status = r1;
    }

    public void setTenantID(String r1) {
        this.tenantID = r1;
    }

    public void setToken(String r1) {
        this.token = r1;
    }

    public void setTotalPage(int r1) {
        this.totalPage = r1;
    }

    public void setType(String r1) {
        this.type = r1;
    }

    public void setUpdate_time(Long r1) {
        this.update_time = r1;
    }

    public void setUrl(String r1) {
        this.url = r1;
    }

    public void setUserToken(String r1) {
        this.userToken = r1;
    }

    public ResourceData(String r3, String r4) {
        this.update_time = Long.valueOf(System.currentTimeMillis());
        this.access_time = Long.valueOf(System.currentTimeMillis());
        this.isNeedSync = false;
        this.page = 0;
        this.totalPage = 1;
        this.reskey = r3;
        this.obj_token = r4;
    }

    public ResourceData(String r3, String r4, String r5) {
        this.update_time = Long.valueOf(System.currentTimeMillis());
        this.access_time = Long.valueOf(System.currentTimeMillis());
        this.isNeedSync = false;
        this.page = 0;
        this.totalPage = 1;
        this.reskey = r3;
        this.type = r4;
        this.resvalue = r5;
    }
}
