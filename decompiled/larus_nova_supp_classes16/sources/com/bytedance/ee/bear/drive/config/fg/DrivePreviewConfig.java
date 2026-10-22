package com.bytedance.ee.bear.drive.config.fg;

import com.bytedance.ee.util.io.NonProguard;
import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import p75.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@AppConfig(key = "drive_preview_config")
public class DrivePreviewConfig implements NonProguard {

    @SerializedName("black_list_add_cache_file_type")
    private String[] blackListAddCacheFileType;
    private long download_origin_file_max_size;
    private int excel_tab_data_max_size;
    private int highlight_max_size;

    @SerializedName("little_bit_rate")
    private int littleBitRate;
    private int local_archive_max_size;

    @SerializedName("max_add_cache_size")
    private long maxAddCacheSize;

    @SerializedName("pdf_max_scale")
    private float pdfMaxScale;

    @SerializedName("pdf_min_scale")
    private float pdfMinScale;
    private int render_html_file_max_size;

    @SerializedName("small_video_size")
    private int smallVideoSize;
    private int text_preview_max_size;

    @SerializedName("video_support_source_preview_type")
    private String[] videoSupportSourcePreviewType;
    private int wps_render_gone_retry_count;
    private long wps_template_timeout;

    public String toString() {
        return "DrivePreviewConfig{text_preview_max_size=" + this.text_preview_max_size + ", highlight_max_size=" + this.highlight_max_size + ", render_html_file_max_size=" + this.render_html_file_max_size + ", excel_tab_data_max_size=" + this.excel_tab_data_max_size + ", download_origin_file_max_size=" + this.download_origin_file_max_size + ", local_archive_max_size=" + this.local_archive_max_size + ", wps_render_gone_retry_count=" + this.wps_render_gone_retry_count + ", wps_template_timeout=" + this.wps_template_timeout + ", small_video_size=" + this.smallVideoSize + ", little_bit_rate=" + this.littleBitRate + '}';
    }

    public DrivePreviewConfig() {
        this.text_preview_max_size = 6144;
        this.highlight_max_size = 500;
        this.render_html_file_max_size = 10240;
        this.excel_tab_data_max_size = 20480;
        this.download_origin_file_max_size = 4194304;
        this.local_archive_max_size = 524288;
        this.wps_render_gone_retry_count = 3;
        this.wps_template_timeout = 3;
        this.smallVideoSize = 20480;
        this.littleBitRate = 1228800;
        this.maxAddCacheSize = 102400;
        this.blackListAddCacheFileType = a.b;
        this.pdfMinScale = 1.0f;
        this.pdfMaxScale = 3.0f;
        this.videoSupportSourcePreviewType = a.a;
    }

    public String[] getBlackListAddCacheFileType() {
        return this.blackListAddCacheFileType;
    }

    public long getDownload_origin_file_max_size() {
        return this.download_origin_file_max_size;
    }

    public int getExcel_tab_data_max_size() {
        return this.excel_tab_data_max_size;
    }

    public int getHighlight_max_size() {
        return this.highlight_max_size;
    }

    public int getLittleBitRate() {
        return this.littleBitRate;
    }

    public int getLocal_archive_max_size() {
        return this.local_archive_max_size;
    }

    public long getMaxAddCacheSize() {
        return this.maxAddCacheSize;
    }

    public float getPdfMaxScale() {
        return this.pdfMaxScale;
    }

    public float getPdfMinScale() {
        return this.pdfMinScale;
    }

    public int getRender_html_file_max_size() {
        return this.render_html_file_max_size;
    }

    public int getSmallVideoSize() {
        return this.smallVideoSize;
    }

    public int getText_preview_max_size() {
        return this.text_preview_max_size;
    }

    public String[] getVideoSupportSourcePreviewType() {
        return this.videoSupportSourcePreviewType;
    }

    public int getWps_render_gone_retry_count() {
        return this.wps_render_gone_retry_count;
    }

    public long getWps_template_timeout() {
        return this.wps_template_timeout;
    }

    public void setBlackListAddCacheFileType(String[] r1) {
        this.blackListAddCacheFileType = r1;
    }

    public void setDownload_origin_file_max_size(long r1) {
        this.download_origin_file_max_size = r1;
    }

    public void setExcel_tab_data_max_size(int r1) {
        this.excel_tab_data_max_size = r1;
    }

    public void setHighlight_max_size(int r1) {
        this.highlight_max_size = r1;
    }

    public void setLittleBitRate(int r1) {
        this.littleBitRate = r1;
    }

    public void setLocal_archive_max_size(int r1) {
        this.local_archive_max_size = r1;
    }

    public void setMaxAddCacheSize(long r1) {
        this.maxAddCacheSize = r1;
    }

    public void setPdfMaxScale(float r1) {
        this.pdfMaxScale = r1;
    }

    public void setPdfMinScale(float r1) {
        this.pdfMinScale = r1;
    }

    public void setRender_html_file_max_size(int r1) {
        this.render_html_file_max_size = r1;
    }

    public void setSmallVideoSize(int r1) {
        this.smallVideoSize = r1;
    }

    public void setText_preview_max_size(int r1) {
        this.text_preview_max_size = r1;
    }

    public void setVideoSupportSourcePreviewType(String[] r1) {
        this.videoSupportSourcePreviewType = r1;
    }

    public void setWps_render_gone_retry_count(int r1) {
        this.wps_render_gone_retry_count = r1;
    }

    public void setWps_template_timeout(long r1) {
        this.wps_template_timeout = r1;
    }
}
