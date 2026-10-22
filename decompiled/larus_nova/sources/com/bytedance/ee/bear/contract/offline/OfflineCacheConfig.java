package com.bytedance.ee.bear.contract.offline;

import com.bytedance.android.live.saas.middleware.alog.config.ALogDefaultConfig;
import com.bytedance.ee.util.io.NonProguard;
import com.google.gson.annotations.SerializedName;
import com.heytap.mcssdk.constant.a;
import com.ss.android.lark.appsetting.annotation.AppConfig;

/* JADX INFO: loaded from: classes16.dex */
@AppConfig(key = "offline_cache_config")
public class OfflineCacheConfig implements NonProguard {

    @SerializedName("category_delete_timeout")
    private int categoryDeleteTimeout;

    @SerializedName("docx_block_preload_number")
    private int docxBlockPreloadNumber;

    @SerializedName("docx_image_block_preload_number")
    private int docxImageBlockPreloadNumber;

    @SerializedName("docx_mention_doc_block_preload_number")
    private int docxMentionDocblockPreloadNumber;

    @SerializedName("docx_office_block_preload_number")
    private int docxOfficeBlockPreloadNumber;

    @SerializedName("docx_office_block_preload_size")
    private int docxOfficeblockPreloadSize;

    @SerializedName("docx_video_block_preload_number")
    private int docxVideoBlockPreloadNumber;

    @SerializedName("docx_video_block_preload_size")
    private int docxVideoblockPreloadSize;
    private int docx_ssr_preload_count;
    private int docx_ssr_preload_cpu_limit;
    private int docx_ssr_preload_look_db_limit;
    private int docx_ssr_preload_uptime;
    private boolean offline_cache_enabled;
    private boolean only_wifi;
    private int preload_clientvar_frequency;
    private int preload_clientvar_number_per_time;
    private boolean preload_image_only_wifi;
    private int preload_pin_number;
    private int recent_list_lru_max;
    private int recent_list_preload_clientvar_number;
    private int sheetSsrMaxCount;
    private int single_doc_max_length;
    private int sync_doc_info_timeout;
    private long update_clientvar_frequency;
    private int update_clientvar_number;

    public long getDocx_ssr_preload_uptime() {
        return (((((long) this.docx_ssr_preload_uptime) * 24) * 60) * 60) * 1000;
    }

    public OfflineCacheConfig() {
        this.offline_cache_enabled = true;
        this.only_wifi = false;
        this.preload_clientvar_frequency = 5000;
        this.preload_clientvar_number_per_time = 10;
        this.update_clientvar_frequency = a.f276320g;
        this.update_clientvar_number = 10;
        this.recent_list_preload_clientvar_number = 20;
        this.preload_image_only_wifi = true;
        this.preload_pin_number = 8;
        this.recent_list_lru_max = 100;
        this.sync_doc_info_timeout = 2000;
        this.single_doc_max_length = 2097152;
        this.docx_ssr_preload_uptime = 30;
        this.docx_ssr_preload_count = 30;
        this.docx_ssr_preload_cpu_limit = 60;
        this.docx_ssr_preload_look_db_limit = 999;
        this.docxBlockPreloadNumber = 100;
        this.docxImageBlockPreloadNumber = 20;
        this.docxVideoBlockPreloadNumber = 5;
        this.docxOfficeBlockPreloadNumber = 5;
        this.docxMentionDocblockPreloadNumber = 5;
        this.docxVideoblockPreloadSize = ALogDefaultConfig.DEVICE_MAX_LOG_SPACE_SIZE;
        this.docxOfficeblockPreloadSize = 20971520;
        this.sheetSsrMaxCount = 5;
        this.categoryDeleteTimeout = 5184000;
    }

    public int getCategoryDeleteTimeout() {
        return this.categoryDeleteTimeout;
    }

    public int getDocxBlockPreloadNumber() {
        return this.docxBlockPreloadNumber;
    }

    public int getDocxImageBlockPreloadNumber() {
        return this.docxImageBlockPreloadNumber;
    }

    public int getDocxMentionDocblockPreloadNumber() {
        return this.docxMentionDocblockPreloadNumber;
    }

    public int getDocxOfficeBlockPreloadNumber() {
        return this.docxOfficeBlockPreloadNumber;
    }

    public int getDocxOfficeblockPreloadSize() {
        return this.docxOfficeblockPreloadSize;
    }

    public int getDocxVideoBlockPreloadNumber() {
        return this.docxVideoBlockPreloadNumber;
    }

    public int getDocxVideoblockPreloadSize() {
        return this.docxVideoblockPreloadSize;
    }

    public int getDocx_ssr_preload_count() {
        return this.docx_ssr_preload_count;
    }

    public int getDocx_ssr_preload_cpu_limit() {
        return this.docx_ssr_preload_cpu_limit;
    }

    public int getDocx_ssr_preload_look_db_limit() {
        return this.docx_ssr_preload_look_db_limit;
    }

    public int getPreload_clientvar_frequency() {
        return this.preload_clientvar_frequency;
    }

    public int getPreload_clientvar_number_per_time() {
        return this.preload_clientvar_number_per_time;
    }

    public int getPreload_pin_number() {
        return this.preload_pin_number;
    }

    public int getRecent_list_lru_max() {
        return this.recent_list_lru_max;
    }

    public int getRecent_list_preload_clientvar_number() {
        return this.recent_list_preload_clientvar_number;
    }

    public int getSheetSsrMaxCount() {
        return this.sheetSsrMaxCount;
    }

    public int getSingle_doc_max_length() {
        return this.single_doc_max_length;
    }

    public int getSync_doc_info_timeout() {
        return this.sync_doc_info_timeout;
    }

    public long getUpdate_clientvar_frequency() {
        return this.update_clientvar_frequency;
    }

    public int getUpdate_clientvar_number() {
        return this.update_clientvar_number;
    }

    public boolean isOffline_cache_enabled() {
        return this.offline_cache_enabled;
    }

    public boolean isOnly_wifi() {
        return this.only_wifi;
    }

    public boolean isPreload_image_only_wifi() {
        return this.preload_image_only_wifi;
    }

    public void setCategoryDeleteTimeout(int r100) {
        this.categoryDeleteTimeout = r100;
    }

    public void setDocxBlockPreloadNumber(int r100) {
        this.docxBlockPreloadNumber = r100;
    }

    public void setDocxImageBlockPreloadNumber(int r100) {
        this.docxImageBlockPreloadNumber = r100;
    }

    public void setDocxMentionDocblockPreloadNumber(int r100) {
        this.docxMentionDocblockPreloadNumber = r100;
    }

    public void setDocxOfficeBlockPreloadNumber(int r100) {
        this.docxOfficeBlockPreloadNumber = r100;
    }

    public void setDocxOfficeblockPreloadSize(int r100) {
        this.docxOfficeblockPreloadSize = r100;
    }

    public void setDocxVideoBlockPreloadNumber(int r100) {
        this.docxVideoBlockPreloadNumber = r100;
    }

    public void setDocxVideoblockPreloadSize(int r100) {
        this.docxVideoblockPreloadSize = r100;
    }

    public void setDocx_ssr_preload_count(int r100) {
        this.docx_ssr_preload_count = r100;
    }

    public void setDocx_ssr_preload_cpu_limit(int r100) {
        this.docx_ssr_preload_cpu_limit = r100;
    }

    public void setDocx_ssr_preload_look_db_limit(int r100) {
        this.docx_ssr_preload_look_db_limit = r100;
    }

    public void setDocx_ssr_preload_uptime(int r100) {
        this.docx_ssr_preload_uptime = r100;
    }

    public void setOffline_cache_enabled(boolean r100) {
        this.offline_cache_enabled = r100;
    }

    public void setOnly_wifi(boolean r100) {
        this.only_wifi = r100;
    }

    public void setPreload_clientvar_frequency(int r100) {
        this.preload_clientvar_frequency = r100;
    }

    public void setPreload_clientvar_number_per_time(int r100) {
        this.preload_clientvar_number_per_time = r100;
    }

    public void setPreload_image_only_wifi(boolean r100) {
        this.preload_image_only_wifi = r100;
    }

    public void setPreload_pin_number(int r100) {
        this.preload_pin_number = r100;
    }

    public void setRecent_list_lru_max(int r100) {
        this.recent_list_lru_max = r100;
    }

    public void setRecent_list_preload_clientvar_number(int r100) {
        this.recent_list_preload_clientvar_number = r100;
    }

    public void setSheetSsrMaxCount(int r100) {
        this.sheetSsrMaxCount = r100;
    }

    public void setSingle_doc_max_length(int r100) {
        this.single_doc_max_length = r100;
    }

    public void setSync_doc_info_timeout(int r100) {
        this.sync_doc_info_timeout = r100;
    }

    public void setUpdate_clientvar_frequency(long r100) {
        this.update_clientvar_frequency = r100;
    }

    public void setUpdate_clientvar_number(int r100) {
        this.update_clientvar_number = r100;
    }
}
