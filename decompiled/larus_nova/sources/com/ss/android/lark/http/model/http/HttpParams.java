package com.ss.android.lark.http.model.http;

import com.alipay.sdk.m.u.i;
import com.huawei.hms.framework.common.ContainerUtils;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import okhttp3.MediaType;

/* JADX INFO: loaded from: classes36.dex */
public class HttpParams implements Serializable {
    public static final boolean IS_REPLACE = true;
    public static final MediaType MEDIA_TYPE_JSON = null;
    public static final MediaType MEDIA_TYPE_PLAIN = null;
    public static final MediaType MEDIA_TYPE_STREAM = null;
    private static final long serialVersionUID = 7369819159227055048L;
    public LinkedHashMap<String, List<FileWrapper>> fileParamsMap;
    public LinkedHashMap<String, String> urlParamsMap;

    public static class FileWrapper implements Serializable {
        private static final long serialVersionUID = -2356139899636767776L;
        public transient MediaType contentType;
        public File file;
        public String fileName;
        public long fileSize;

        public String toString() {
            return "FileWrapper{file=" + this.file + ", fileName=" + this.fileName + ", contentType=" + this.contentType + ", fileSize=" + this.fileSize + i.f25855d;
        }

        private void readObject(ObjectInputStream r100) throws IOException, ClassNotFoundException {
            r100.defaultReadObject();
            this.contentType = MediaType.parse((String) r100.readObject());
        }

        private void writeObject(ObjectOutputStream r100) throws IOException {
            r100.defaultWriteObject();
            r100.writeObject(this.contentType.toString());
        }

        public FileWrapper(File r100, String r101, MediaType r102) {
            this.file = r100;
            this.fileName = r101;
            this.contentType = r102;
            this.fileSize = r100.length();
        }
    }

    static {
        MEDIA_TYPE_PLAIN = MediaType.parse(com.larksuite.framework.http.request.HttpParams.RAW_TYPE_PLAIN);
        MEDIA_TYPE_JSON = MediaType.parse(com.larksuite.framework.http.request.HttpParams.RAW_TYPE_JSON);
        MEDIA_TYPE_STREAM = MediaType.parse("application/octet-stream");
    }

    public void clear() {
        this.urlParamsMap.clear();
        this.fileParamsMap.clear();
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder();
        Iterator<Map.Entry<String, String>> r101 = this.urlParamsMap.entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        Map.Entry<String, String> r102 = r101.next();
        if (r100.length() <= 0) goto L8;
        r100.append("&");
    L8:
        r100.append(r102.getKey());
        r100.append(ContainerUtils.KEY_VALUE_DELIMITER);
        r100.append(r102.getValue());
        goto L4
    L9:
        Iterator<Map.Entry<String, List<FileWrapper>>> r103 = this.fileParamsMap.entrySet().iterator();
    L11:
        if (r103.hasNext() == false) goto L17;
        Map.Entry<String, List<FileWrapper>> r104 = r103.next();
        if (r100.length() <= 0) goto L15;
        r100.append("&");
    L15:
        r100.append(r104.getKey());
        r100.append(ContainerUtils.KEY_VALUE_DELIMITER);
        r100.append(r104.getValue());
        goto L11
    L17:
        return r100.toString();
    }

    public HttpParams() {
        this.urlParamsMap = new LinkedHashMap();
        this.fileParamsMap = new LinkedHashMap();
    }

    public void put(HttpParams r100) {
        if (r100 == null) goto L14;
        LinkedHashMap<String, String> r101 = r100.urlParamsMap;
        if (r101 != null) goto L6;
    L8:
        LinkedHashMap<String, List<FileWrapper>> r102 = r100.fileParamsMap;
        if (r102 != null) goto L11;
        return;
    L11:
        if (r102.isEmpty() == true) goto L16;
        this.fileParamsMap.putAll(r100.fileParamsMap);
        return;
    L16:
        return;
    L6:
        if (r101.isEmpty() == true) goto L8;
        this.urlParamsMap.putAll(r100.urlParamsMap);
        goto L8
    }

    public void remove(String r100) {
        removeUrl(r100);
        removeFile(r100);
    }

    public void removeFile(String r100) {
        this.fileParamsMap.remove(r100);
    }

    public void removeUrl(String r100) {
        this.urlParamsMap.remove(r100);
    }

    public HttpParams(String r100, File r101) {
        this.urlParamsMap = new LinkedHashMap();
        this.fileParamsMap = new LinkedHashMap();
        put(r100, r101);
    }

    public final void a(String r100, String r101) {
        if (r100 == null) goto L6;
        if (r101 == null) goto L7;
        this.urlParamsMap.put(r100, r101);
        return;
    L7:
        return;
    }

    public void put(Map<String, String> r100, boolean... r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.isEmpty() == true) goto L12;
        Iterator<Map.Entry<String, String>> r102 = r100.entrySet().iterator();
    L8:
        if (r102.hasNext() == false) goto L13;
        Map.Entry<String, String> r103 = r102.next();
        put(r103.getKey(), r103.getValue(), r101);
        goto L8
    L13:
        return;
    }

    public void putFileParams(String r100, List<File> r101) {
        if (r100 == null) goto L10;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.isEmpty() == true) goto L13;
        Iterator<File> r102 = r101.iterator();
    L8:
        if (r102.hasNext() == false) goto L14;
        put(r100, r102.next());
        goto L8
    L14:
        return;
    L13:
        return;
    }

    public void putFileWrapperParams(String r100, List<FileWrapper> r101) {
        if (r100 == null) goto L10;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.isEmpty() == true) goto L13;
        Iterator<FileWrapper> r102 = r101.iterator();
    L8:
        if (r102.hasNext() == false) goto L14;
        put(r100, r102.next());
        goto L8
    L14:
        return;
    L13:
        return;
    }

    public void putUrlParams(String r100, List<String> r101) {
        if (r100 == null) goto L10;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.isEmpty() == true) goto L13;
        Iterator<String> r102 = r101.iterator();
    L8:
        if (r102.hasNext() == false) goto L14;
        a(r100, r102.next());
        goto L8
    L14:
        return;
    L13:
        return;
    }

    public HttpParams(String r100, String r101) {
        this.urlParamsMap = new LinkedHashMap();
        this.fileParamsMap = new LinkedHashMap();
        a(r100, r101);
    }

    public void put(String r100, FileWrapper r101) {
        if (r100 == null) goto L6;
        if (r101 == null) goto L7;
        put(r100, r101.file, r101.fileName, r101.contentType);
        return;
    L7:
        return;
    }

    public void put(String r100, File r101) {
        put(r100, r101, r101.getName());
    }

    public void put(String r100, File r101, String r102) {
        String r103 = URLConnection.getFileNameMap().getContentTypeFor(r102.replace("#", ""));
        if (r103 != null) goto L5;
        MediaType r104 = MEDIA_TYPE_STREAM;
    L6:
        put(r100, r101, r102, r104);
        return;
    L5:
        r104 = MediaType.parse(r103);
        goto L6
    }

    public void put(String r100, char r101, boolean... r102) {
        if (r102 != null) goto L4;
    L6:
        a(r100, String.valueOf(r101));
        return;
    L4:
        if (r102.length <= 0) goto L6;
        String r103 = String.valueOf(r101);
        boolean r104 = r102[0];
        a(r100, r103);
    }

    public void put(String r100, double r101, boolean... r102) {
        if (r102 != null) goto L4;
    L6:
        a(r100, String.valueOf(r101));
        return;
    L4:
        if (r102.length <= 0) goto L6;
        String r103 = String.valueOf(r101);
        boolean r104 = r102[0];
        a(r100, r103);
    }

    public void put(String r100, float r101, boolean... r102) {
        if (r102 != null) goto L4;
    L6:
        a(r100, String.valueOf(r101));
        return;
    L4:
        if (r102.length <= 0) goto L6;
        String r103 = String.valueOf(r101);
        boolean r104 = r102[0];
        a(r100, r103);
    }

    public void put(String r100, int r101, boolean... r102) {
        if (r102 != null) goto L4;
    L6:
        a(r100, String.valueOf(r101));
        return;
    L4:
        if (r102.length <= 0) goto L6;
        String r103 = String.valueOf(r101);
        boolean r104 = r102[0];
        a(r100, r103);
    }

    public void put(String r100, long r101, boolean... r102) {
        if (r102 != null) goto L4;
    L6:
        a(r100, String.valueOf(r101));
        return;
    L4:
        if (r102.length <= 0) goto L6;
        String r103 = String.valueOf(r101);
        boolean r104 = r102[0];
        a(r100, r103);
    }

    public void put(String r100, boolean r101, boolean... r102) {
        if (r102 != null) goto L4;
    L6:
        a(r100, String.valueOf(r101));
        return;
    L4:
        if (r102.length <= 0) goto L6;
        String r103 = String.valueOf(r101);
        boolean r104 = r102[0];
        a(r100, r103);
    }

    public void put(String r100, String r101, boolean... r102) {
        if (r102 != null) goto L4;
    L6:
        a(r100, r101);
        return;
    L4:
        if (r102.length <= 0) goto L6;
        boolean r103 = r102[0];
        a(r100, r101);
    }

    public void put(String r100, File r101, String r102, MediaType r103) {
        if (r100 == null) goto L8;
        List<FileWrapper> r104 = this.fileParamsMap.get(r100);
        if (r104 != null) goto L6;
        r104 = new ArrayList();
        this.fileParamsMap.put(r100, r104);
    L6:
        r104.add(new FileWrapper(r101, r102, r103));
        return;
    }
}
