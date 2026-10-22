package com.bytedance.security.android.aopcheck.settings;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes3.dex */
public class SettingsModel {

    @SerializedName("path_traversal_content_resolver_intercept_enabled")
    private Boolean enableContentResolverIntercept;

    @SerializedName("path_traversal_file_input_stream_intercept_enabled")
    private Boolean enableFileInputStreamIntercept;

    @SerializedName("path_traversal_file_intercept_enabled")
    private Boolean enableFileIntercept;

    @SerializedName("path_traversal_file_output_stream_intercept_enabled")
    private Boolean enableFileOutputStreamIntercept;

    @SerializedName("path_traversal_file_reader_intercept_enabled")
    private Boolean enableFileReaderIntercept;

    @SerializedName("path_traversal_file_writer_intercept_enabled")
    private Boolean enableFileWriterIntercept;

    @SerializedName("path_traversal_zip_file_intercept_enabled")
    private Boolean enableZipFileIntercept;

    @SerializedName("name")
    private String name;

    @SerializedName("path_traversal_enabled")
    private Boolean pathTraversalEnabled;

    @SerializedName("path_traversal_intercept_enabled")
    private Boolean pathTraversalInterceptEnabled;

    @SerializedName("version")
    private String version;

    public String toString() {
        return "SettingsModel{pathTraversalInterceptEnabled=" + this.pathTraversalInterceptEnabled + ", enableFileIntercept=" + this.enableFileIntercept + ", enableFileInputStreamIntercept=" + this.enableFileInputStreamIntercept + ", enableFileOutputStreamIntercept=" + this.enableFileOutputStreamIntercept + ", enableFileReaderIntercept=" + this.enableFileReaderIntercept + ", enableFileWriterIntercept=" + this.enableFileWriterIntercept + ", pathTraversalInterceptEnabled=" + this.pathTraversalInterceptEnabled + ", enableZipFileIntercept=" + this.enableZipFileIntercept + ", enableContentResolverIntercept=" + this.enableContentResolverIntercept + '}';
    }

    public SettingsModel() {
        this.version = "";
        this.name = "";
        Boolean r100 = Boolean.FALSE;
        this.pathTraversalInterceptEnabled = r100;
        this.enableFileIntercept = r100;
        this.enableFileInputStreamIntercept = r100;
        this.enableFileOutputStreamIntercept = r100;
        this.enableFileReaderIntercept = r100;
        this.enableFileWriterIntercept = r100;
        this.enableZipFileIntercept = r100;
        this.enableContentResolverIntercept = r100;
        this.pathTraversalEnabled = Boolean.TRUE;
    }

    public Boolean getEnableContentResolverIntercept() {
        return this.enableContentResolverIntercept;
    }

    public Boolean getEnableFileInputStreamIntercept() {
        return this.enableFileInputStreamIntercept;
    }

    public Boolean getEnableFileIntercept() {
        return this.enableFileIntercept;
    }

    public Boolean getEnableFileOutputStreamIntercept() {
        return this.enableFileOutputStreamIntercept;
    }

    public Boolean getEnableFileReaderIntercept() {
        return this.enableFileReaderIntercept;
    }

    public Boolean getEnableFileWriterIntercept() {
        return this.enableFileWriterIntercept;
    }

    public Boolean getEnableZipFileIntercept() {
        return this.enableZipFileIntercept;
    }

    public String getName() {
        return this.name;
    }

    public Boolean getPathTraversalEnabled() {
        return this.pathTraversalEnabled;
    }

    public Boolean getPathTraversalInterceptEnabled() {
        return this.pathTraversalInterceptEnabled;
    }

    public String getVersion() {
        return this.version;
    }

    public void setEnableContentResolverIntercept(Boolean r100) {
        this.enableContentResolverIntercept = r100;
    }

    public void setEnableFileInputStreamIntercept(Boolean r100) {
        this.enableFileInputStreamIntercept = r100;
    }

    public void setEnableFileIntercept(Boolean r100) {
        this.enableFileIntercept = r100;
    }

    public void setEnableFileOutputStreamIntercept(Boolean r100) {
        this.enableFileOutputStreamIntercept = r100;
    }

    public void setEnableFileReaderIntercept(Boolean r100) {
        this.enableFileReaderIntercept = r100;
    }

    public void setEnableFileWriterIntercept(Boolean r100) {
        this.enableFileWriterIntercept = r100;
    }

    public void setEnableZipFileIntercept(Boolean r100) {
        this.enableZipFileIntercept = r100;
    }

    public void setName(String r100) {
        this.name = r100;
    }

    public void setPathTraversalEnabled(Boolean r100) {
        this.pathTraversalEnabled = r100;
    }

    public void setPathTraversalInterceptEnabled(Boolean r100) {
        this.pathTraversalInterceptEnabled = r100;
    }

    public void setVersion(String r100) {
        this.version = r100;
    }
}
