package com.ss.android.ugc.effectmanager.link.model.host;

import android.text.TextUtils;
import java.net.URI;

/* JADX INFO: loaded from: classes5.dex */
public class Host {
    private String host;
    private String path;
    private int port;
    private String schema;
    private long sortTime;
    private long weightTime;

    public String getItemName() {
        String r100 = getSchema() + "://" + getHost();
        if (this.port == (-1)) goto L6;
        r100 = r100 + ":" + this.port;
    L6:
        if (TextUtils.isEmpty(this.path) == false) goto L8;
        return r100;
    L8:
        return r100 + this.path;
    }

    public long getSortTime() {
        return this.sortTime + this.weightTime;
    }

    public String toString() {
        return "Host{weightTime=" + this.weightTime + ", schema='" + this.schema + "', host='" + this.host + "'}";
    }

    public String getHost() {
        return this.host;
    }

    public int getPort() {
        return this.port;
    }

    public String getSchema() {
        return this.schema;
    }

    public long getWeightTime() {
        return this.weightTime;
    }

    public Host(String r100) {
        this.port = -1;
        URI r101 = URI.create(r100);
        this.host = r101.getHost();
        this.schema = r101.getScheme();
        this.port = r101.getPort();
        this.path = r101.getPath();
    }

    public boolean hostEquals(Host r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r100.getHost().equals(getHost()) == true) goto L8;
        return false;
    L8:
        if (r100.getSchema().equals(getSchema()) == false) goto L12;
        return true;
    L12:
        return false;
    }

    public void setHost(String r100) {
        this.host = r100;
    }

    public void setPort(int r100) {
        this.port = r100;
    }

    public void setSchema(String r100) {
        this.schema = r100;
    }

    public void setSortTime(long r100) {
        this.sortTime = r100;
    }

    public void setWeightTime(long r100) {
        this.weightTime = r100;
    }

    public Host(URI r100) {
        this.port = -1;
        this.host = r100.getHost();
        this.schema = r100.getScheme();
        this.path = r100.getPath();
    }

    public Host(String r100, String r101) {
        this.port = -1;
        this.host = r100;
        this.schema = r101;
    }

    public Host(String r100, String r101, long r102) {
        this.port = -1;
        this.host = r100;
        this.schema = r101;
        this.weightTime = r102;
    }
}
