package com.ss.android.lark.chat.entity.message.content;

import com.bytedance.badger.collect.impl.constants.Constants;
import com.ss.android.lark.chat.entity.image.ImageSet;
import com.ss.android.lark.chat.entity.location.LocationDescription;
import com.ss.android.lark.chat.export.entity.message.Content;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u0000 +2\u00020\u0001:\u0001+B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\r\"\u0004\b!\u0010\u000fR\u001a\u0010\"\u001a\u00020#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010$\"\u0004\b%\u0010&R\u0011\u0010'\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b(\u0010\rR\u0011\u0010)\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b*\u0010\r¨\u0006,"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/content/LocationContent;", "Lcom/ss/android/lark/chat/export/entity/message/Content;", "<init>", "()V", "locationDescription", "Lcom/ss/android/lark/chat/entity/location/LocationDescription;", "getLocationDescription", "()Lcom/ss/android/lark/chat/entity/location/LocationDescription;", "setLocationDescription", "(Lcom/ss/android/lark/chat/entity/location/LocationDescription;)V", "longitude", "", "getLongitude", "()Ljava/lang/String;", "setLongitude", "(Ljava/lang/String;)V", "latitude", "getLatitude", "setLatitude", "zoomLevel", "", "getZoomLevel", "()I", "setZoomLevel", "(I)V", "image", "Lcom/ss/android/lark/chat/entity/image/ImageSet;", "getImage", "()Lcom/ss/android/lark/chat/entity/image/ImageSet;", "setImage", "(Lcom/ss/android/lark/chat/entity/image/ImageSet;)V", Constants.OperatorKey.KEY_VENDOR, "getVendor", "setVendor", "isInternal", "", "()Z", "setInternal", "(Z)V", "name", "getName", "description", "getDescription", "Companion", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LocationContent extends Content {
    public static final a Companion = null;
    private static final long serialVersionUID = 0;
    private ImageSet image;
    private boolean isInternal;
    private String latitude;
    private LocationDescription locationDescription;
    private String longitude;

    /* JADX INFO: renamed from: vendor, reason: collision with root package name */
    private String f415338vendor;
    private int zoomLevel;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
        serialVersionUID = 1940130775058004397L;
    }

    public final String getDescription() {
        LocationDescription r100 = this.locationDescription;
        if (r100 == null) goto L6;
        String r101 = r100.getDescription();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    public final String getName() {
        LocationDescription r100 = this.locationDescription;
        if (r100 == null) goto L6;
        String r101 = r100.getName();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    public LocationContent() {
    }

    public final ImageSet getImage() {
        return this.image;
    }

    public final String getLatitude() {
        return this.latitude;
    }

    public final LocationDescription getLocationDescription() {
        return this.locationDescription;
    }

    public final String getLongitude() {
        return this.longitude;
    }

    public final String getVendor() {
        return this.f415338vendor;
    }

    public final int getZoomLevel() {
        return this.zoomLevel;
    }

    public final boolean isInternal() {
        return this.isInternal;
    }

    public final void setImage(ImageSet r100) {
        this.image = r100;
    }

    public final void setInternal(boolean r100) {
        this.isInternal = r100;
    }

    public final void setLatitude(String r100) {
        this.latitude = r100;
    }

    public final void setLocationDescription(LocationDescription r100) {
        this.locationDescription = r100;
    }

    public final void setLongitude(String r100) {
        this.longitude = r100;
    }

    public final void setVendor(String r100) {
        this.f415338vendor = r100;
    }

    public final void setZoomLevel(int r100) {
        this.zoomLevel = r100;
    }
}
