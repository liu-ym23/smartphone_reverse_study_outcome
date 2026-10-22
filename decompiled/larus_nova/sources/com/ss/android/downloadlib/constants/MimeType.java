package com.ss.android.downloadlib.constants;

import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes34.dex */
public @interface MimeType {
    public static final String APK = "application/vnd.android.package-archive";
    public static final String AUDIO_REG = "audio/.+";
    public static final String AVI = "video/x-msvideo";
    public static final String CSV = "text/csv";
    public static final String DOC = "application/msword";
    public static final String DOCX = "application/vnd.openxmlformats-officedocument.wordprocessingml.document";
    public static final String EPUB = "application/epub+zip";
    public static final String EXE = "application/vnd.microsoft.portable-executable";
    public static final String GIF = "image/gif";
    public static final String HTML = "text/html";
    public static final String IMG_REG = "image/.+";
    public static final String JPEG = "image/jpeg";
    public static final String MOBI = "application/x-mobipocket-ebook";
    public static final String MOV = "video/quicktime";
    public static final String MP3 = "audio/mpeg";
    public static final String MP4 = "video/mp4";
    public static final List<String> NOT_APK_TYPE = null;
    public static final String P7Z = "application/x-7z-compressed";
    public static final String PDF = "application/pdf";
    public static final String PDFX = "application/x-pdf";
    public static final String PDF_REG = "(application/pdf)|(application/((?i)x)-pdf)";
    public static final String PNG = "image/png";
    public static final String PPT = "application/vnd.ms-powerpoint";
    public static final String PPTX = "application/vnd.openxmlformats-officedocument.presentationml.presentation";
    public static final String RAR = "application/x-rar-compressed";
    public static final String TEXT_REG = "text/.+";
    public static final String TIFF = "image/tiff";
    public static final String TXT = "text/plain";
    public static final String UNKNOWN = "application/octet-stream";
    public static final String VIDEO_REG = "video/.+";
    public static final String WAV = "audio/wav";
    public static final String WAVX = "audio/x-wav";
    public static final String WEBP = "image/webp";
    public static final String WMV = "video/x-ms-wmv";
    public static final String XLS = "application/vnd.ms-excel";
    public static final String XLSX = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    public static final String ZIP = "application/zip";

    static {
        NOT_APK_TYPE = Arrays.asList(new String[]{TEXT_REG, "text/plain", "text/html", CSV, EPUB, MOBI, PDF_REG, PDF, PDFX, DOC, DOCX, XLS, XLSX, PPT, PPTX, ZIP, RAR, P7Z, IMG_REG, "image/jpeg", "image/png", GIF, TIFF, WEBP, AUDIO_REG, MP3, WAV, WAVX, VIDEO_REG, MP4, MOV, AVI, WMV, EXE});
    }
}
