package com.ss.android.lark.biz.im.api;

import android.text.TextUtils;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.location.dto.LarkLocation;
import java.io.Serializable;

/* JADX INFO: loaded from: classes34.dex */
public class LocationInfo implements Serializable, Cloneable {
    LarkLocation.CoordinateSystem coordinateSystem;
    private String desc;
    boolean disallowLatLngTransformation;
    private boolean isInternal;
    private boolean isNeedGCTLatLng;
    private boolean isSecretChat;
    private String latitude;
    private String longitude;
    private Message message;
    private String name;
    private int zoomLevel;

    public static /* synthetic */ class a {
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Message f409872a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f409873b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f409874c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f409875d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f409876e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f409877f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f409878g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f409879h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f409880i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final LarkLocation.CoordinateSystem f409881j;

        public b(String r100, String r101) {
            this.f409881j = LarkLocation.CoordinateSystem.DEFAULT;
            this.f409876e = r100;
            this.f409875d = r101;
        }
    }

    public boolean isHideTitleBar() {
        if (this.message != null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isNameAndDescEmpty() {
        if (TextUtils.isEmpty(this.name) == true) goto L5;
    L7:
        return false;
    L5:
        if (TextUtils.isEmpty(this.desc) == false) goto L7;
        return true;
    }

    public boolean disallowLatLngTransformation() {
        return this.disallowLatLngTransformation;
    }

    public LarkLocation.CoordinateSystem getCoordinateSystem() {
        return this.coordinateSystem;
    }

    public String getDesc() {
        return this.desc;
    }

    public String getLatitude() {
        return this.latitude;
    }

    public String getLongitude() {
        return this.longitude;
    }

    public Message getMessage() {
        return this.message;
    }

    public String getName() {
        return this.name;
    }

    public int getZoomLevel() {
        return this.zoomLevel;
    }

    public boolean isInternal() {
        return this.isInternal;
    }

    public boolean isNeedGCTLatLng() {
        return this.isNeedGCTLatLng;
    }

    public boolean isSecretChat() {
        return this.isSecretChat;
    }

    public LocationInfo(b r100, a r101) {
        this.message = r100.f409872a;
        this.name = r100.f409873b;
        this.desc = r100.f409874c;
        this.latitude = r100.f409876e;
        this.longitude = r100.f409875d;
        this.zoomLevel = r100.f409877f;
        this.isSecretChat = r100.f409878g;
        this.isInternal = r100.f409879h;
        this.isNeedGCTLatLng = r100.f409880i;
        this.disallowLatLngTransformation = false;
        this.coordinateSystem = r100.f409881j;
    }
}
