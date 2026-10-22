package com.ss.android.lark.widget.photopickerimpl.model;

import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.log.Log;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.tencent.connect.share.QzonePublish;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes38.dex */
public final class AlbumHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Uri f447757a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Uri f447758b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Uri f447759c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Uri f447760d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Uri f447761e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String[] f447762f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String[] f447763g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String[] f447764h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String[] f447765i = null;

    public static final class BucketInfo implements Serializable {
        private static final long serialVersionUID = -2232895995725474230L;

        @SerializedName("bucketType")
        private BucketType bucketType;

        @SerializedName("count")
        private int count;

        @SerializedName("coverUri")
        public Uri coverUri;

        @SerializedName("dateTaken")
        public long dateTaken;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        @SerializedName("id")
        private int f447766id;

        @SerializedName("imgPath")
        private String imgPath;

        @SerializedName(DBDefinition.MIME_TYPE)
        public String mimeType;

        @SerializedName("name")
        private String name;

        @SerializedName("path")
        private String path;

        @SerializedName("position")
        private int position;

        public String toString() {
            return "BucketInfo id=" + this.f447766id + " name=" + this.name + " count=" + this.count + " path=" + this.path + " imgPath=" + this.imgPath;
        }

        public BucketInfo() {
            this.name = "";
            this.count = 0;
            this.path = "";
            this.imgPath = "";
            this.position = Integer.MAX_VALUE;
            this.bucketType = BucketType.MEDIA;
            this.dateTaken = 0;
        }

        public BucketType getBucketType() {
            return this.bucketType;
        }

        public int getCount() {
            return this.count;
        }

        public int getId() {
            return this.f447766id;
        }

        public String getImgPath() {
            return this.imgPath;
        }

        public String getName() {
            return this.name;
        }

        public String getPath() {
            return this.path;
        }

        public int getPosition() {
            return this.position;
        }

        public int hashCode() {
            return this.f447766id;
        }

        public static /* synthetic */ String access$300(BucketInfo r100) {
            return r100.imgPath;
        }

        public static /* synthetic */ String access$400(BucketInfo r100) {
            return r100.name;
        }

        public static /* synthetic */ int access$500(BucketInfo r100) {
            return r100.f447766id;
        }

        public boolean equals(Object r100) {
            if (r100 != null) goto L5;
            return false;
        L5:
            if ((r100 instanceof BucketInfo) == true) goto L7;
            return false;
        L7:
            if (this.f447766id != ((BucketInfo) r100).getId()) goto L12;
            return true;
        L12:
            return false;
        }

        public void setBucketType(BucketType r100) {
            this.bucketType = r100;
        }

        public void setCount(int r100) {
            this.count = r100;
        }

        public void setId(int r100) {
            this.f447766id = r100;
        }

        public void setImgPath(String r100) {
            this.imgPath = r100;
        }

        public void setName(String r100) {
            this.name = r100;
        }

        public void setPath(String r100) {
            this.path = r100;
        }

        public void setPosition(int r100) {
            this.position = r100;
        }

        public static /* synthetic */ String access$302(BucketInfo r100, String r101) {
            r100.imgPath = r101;
            return r101;
        }
    }

    public static abstract enum BucketType extends Enum<BucketType> {
        public static final BucketType IMAGE = null;
        public static final BucketType IMAGE_ALL = null;
        public static final BucketType MEDIA = null;
        public static final BucketType MEDIA_ALL = null;
        public static final BucketType VIDEO = null;
        public static final BucketType VIDEO_ALL = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ BucketType[] f447767a = null;

        public BucketType() {
            throw null;
        }

        public abstract List<MediaInfo> getBucketData(Context r100, int r101);

        static {
            final String r100 = "IMAGE";
            final int r101 = 0;
            BucketType r102 = new AnonymousClass1(r100, r101);
            IMAGE = r102;
            final String r103 = "VIDEO";
            final int r104 = 1;
            BucketType r105 = new AnonymousClass2(r103, r104);
            VIDEO = r105;
            final String r106 = "MEDIA";
            final int r107 = 2;
            BucketType r108 = new AnonymousClass3(r106, r107);
            MEDIA = r108;
            final String r109 = "IMAGE_ALL";
            final int r110 = 3;
            BucketType r111 = new AnonymousClass4(r109, r110);
            IMAGE_ALL = r111;
            final String r112 = "VIDEO_ALL";
            final int r113 = 4;
            BucketType r114 = new AnonymousClass5(r112, r113);
            VIDEO_ALL = r114;
            final String r115 = "MEDIA_ALL";
            final int r116 = 5;
            BucketType r117 = new AnonymousClass6(r115, r116);
            MEDIA_ALL = r117;
            f447767a = new BucketType[]{r102, r105, r108, r111, r114, r117};
        }

        public static BucketType[] values() {
            return (BucketType[]) f447767a.clone();
        }

        public static BucketType valueOf(String r100) {
            return (BucketType) r27.a.a(BucketType.class, r100);
        }

        public BucketType(String r100, int r101, a r102) {
            super(r100, r101);
        }
    }

    public static final class ImageInfo extends MediaInfo {
        private static final long serialVersionUID = 5208878923301253439L;
        private String fromImage;

        @SerializedName("imagePath")
        private String imagePath;
        private String originImage;

        @Override // com.ss.android.lark.widget.photopickerimpl.model.AlbumHelper.MediaInfo
        public int getMediaType() {
            return 1;
        }

        @Override // com.ss.android.lark.widget.photopickerimpl.model.AlbumHelper.MediaInfo
        public Uri getThumbnailsUri() {
            int r100 = this.thumbId;
            if (r100 <= 0) goto L7;
            return ContentUris.withAppendedId(AlbumHelper.f447758b, r100);
        L7:
            return getUri();
        }

        @Override // com.ss.android.lark.widget.photopickerimpl.model.AlbumHelper.MediaInfo
        public Uri getUri() {
            return ContentUris.withAppendedId(AlbumHelper.f447757a, getId());
        }

        public ImageInfo() {
            this.fromImage = null;
            this.originImage = null;
        }

        @Override // com.ss.android.lark.widget.photopickerimpl.model.AlbumHelper.MediaInfo
        public String getShowImagePath() {
            return getImagePath();
        }

        public String getFromImage() {
            return this.fromImage;
        }

        public String getImagePath() {
            return this.imagePath;
        }

        public String getOriginImage() {
            return this.originImage;
        }

        public void setFromImage(String r100) {
            this.fromImage = r100;
        }

        public void setImagePath(String r100) {
            this.imagePath = r100;
        }

        public void setOriginImage(String r100) {
            this.originImage = r100;
        }
    }

    public static abstract class MediaInfo implements Serializable, Comparable<MediaInfo> {
        public static final int MEDIA_TYPE_IMAGE = 1;
        public static final int MEDIA_TYPE_VIDEO = 2;
        private static final long serialVersionUID = 4768639343898021972L;

        @SerializedName("dateTaken")
        private long dateTaken;

        @SerializedName("extra")
        public String extra;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        @SerializedName("id")
        private int f447768id;

        @SerializedName("imageHeight")
        private int imageHeight;

        @SerializedName("imageWidth")
        private int imageWidth;

        @SerializedName("isSelect")
        private boolean isSelect;

        @SerializedName("isValid")
        private boolean isValid;

        @SerializedName(DBDefinition.MIME_TYPE)
        public String mimeType;

        @SerializedName("isSelect")
        private int position;

        @SerializedName("size")
        public long size;

        @SerializedName("thumbId")
        public int thumbId;

        @SerializedName("thumbImagePath")
        private String thumbImagePath;

        public abstract int getMediaType();

        public abstract String getShowImagePath();

        public abstract Uri getThumbnailsUri();

        public abstract Uri getUri();

        public MediaInfo() {
            this.isSelect = false;
            this.isValid = true;
        }

        public long getDateTaken() {
            return this.dateTaken;
        }

        public int getId() {
            return this.f447768id;
        }

        public int getImageHeight() {
            return this.imageHeight;
        }

        public int getImageWidth() {
            return this.imageWidth;
        }

        public String getMimeType() {
            return this.mimeType;
        }

        public int getPosition() {
            return this.position;
        }

        public long getSize() {
            return this.size;
        }

        public String getThumbImagePath() {
            return this.thumbImagePath;
        }

        public boolean isSelect() {
            return this.isSelect;
        }

        public boolean isValid() {
            return this.isValid;
        }

        /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
        public int compareTo2(MediaInfo r100) {
            if (r100.getDateTaken() <= this.dateTaken) goto L7;
            return 1;
        L7:
            if (r100.getDateTaken() >= this.dateTaken) goto L10;
            return -1;
        L10:
            return 0;
        }

        public void setDateTaken(long r100) {
            this.dateTaken = r100;
        }

        public void setId(int r100) {
            this.f447768id = r100;
        }

        public void setImageHeight(int r100) {
            this.imageHeight = r100;
        }

        public void setImageWidth(int r100) {
            this.imageWidth = r100;
        }

        public void setMimeType(String r100) {
            this.mimeType = r100;
        }

        public void setPosition(int r100) {
            this.position = r100;
        }

        public void setSelect(boolean r100) {
            this.isSelect = r100;
        }

        public void setSize(long r100) {
            this.size = r100;
        }

        public void setThumbImagePath(String r100) {
            this.thumbImagePath = r100;
        }

        public void setValid(boolean r100) {
            this.isValid = r100;
        }

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(MediaInfo r100) {
            return compareTo2(r100);
        }
    }

    public static final class VideoInfo extends MediaInfo {
        private static final long serialVersionUID = 545412099904598687L;

        @SerializedName("duration")
        private long duration;

        @SerializedName("isValid")
        private boolean isValid;

        @SerializedName("resolution")
        private String resolution;

        @SerializedName(QzonePublish.PUBLISH_TO_QZONE_VIDEO_PATH)
        private String videoPath;

        @Override // com.ss.android.lark.widget.photopickerimpl.model.AlbumHelper.MediaInfo
        public int getMediaType() {
            return 2;
        }

        @Override // com.ss.android.lark.widget.photopickerimpl.model.AlbumHelper.MediaInfo
        public Uri getThumbnailsUri() {
            int r100 = this.thumbId;
            if (r100 <= 0) goto L7;
            return ContentUris.withAppendedId(AlbumHelper.f447760d, r100);
        L7:
            return getUri();
        }

        @Override // com.ss.android.lark.widget.photopickerimpl.model.AlbumHelper.MediaInfo
        public Uri getUri() {
            return ContentUris.withAppendedId(AlbumHelper.f447759c, getId());
        }

        public VideoInfo() {
            this.isValid = false;
        }

        @Override // com.ss.android.lark.widget.photopickerimpl.model.AlbumHelper.MediaInfo
        public String getShowImagePath() {
            return getVideoPath();
        }

        public long getDuration() {
            return this.duration;
        }

        public String getResolution() {
            return this.resolution;
        }

        public String getVideoPath() {
            return this.videoPath;
        }

        @Override // com.ss.android.lark.widget.photopickerimpl.model.AlbumHelper.MediaInfo
        public boolean isValid() {
            return this.isValid;
        }

        public static /* synthetic */ String access$600(VideoInfo r100) {
            return r100.videoPath;
        }

        public void setDuration(long r100) {
            this.duration = r100;
        }

        public void setResolution(String r100) {
            this.resolution = r100;
        }

        @Override // com.ss.android.lark.widget.photopickerimpl.model.AlbumHelper.MediaInfo
        public void setValid(boolean r100) {
            this.isValid = r100;
        }

        public void setVideoPath(String r100) {
            this.videoPath = r100;
        }
    }

    public static /* synthetic */ class a {
    }

    static {
        f447757a = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        f447758b = MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI;
        f447759c = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        f447760d = MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI;
        f447761e = MediaStore.Files.getContentUri("external");
        new HashMap();
        new String[]{"bucket_id", "bucket_display_name", "datetaken", "_data", "_display_name", "count(*)"};
        new String[]{"bucket_id", "bucket_display_name", "datetaken", "_data", "_display_name", "count(*)"};
        new String[]{"bucket_id", "bucket_display_name", "datetaken", "_data", DBDefinition.ID, "mime_type"};
        new String[]{"bucket_id", "bucket_display_name", "datetaken", "_data", DBDefinition.ID, "_display_name", "mime_type"};
        f447762f = new String[]{"bucket_id", "bucket_display_name", "datetaken", "_data", DBDefinition.ID, "_display_name", "mime_type"};
        f447763g = new String[]{DBDefinition.ID, "_data", "datetaken", "date_added", "latitude", "longitude", "bucket_display_name", "mime_type", "_size"};
        f447764h = new String[]{DBDefinition.ID, "_data", "image_id"};
        new String[]{DBDefinition.ID, "_data", "mime_type", "duration", "_size", "resolution", "datetaken"};
        f447765i = new String[]{DBDefinition.ID, "_data", "video_id"};
    }

    public static BucketInfo a(Cursor r100) {
        BucketInfo r101 = new BucketInfo();
        r101.setId(r100.getInt(r100.getColumnIndex("bucket_id")));     // Catch: Exception -> L8
        r101.setName(r100.getString(r100.getColumnIndex("bucket_display_name")));     // Catch: Exception -> L8
        int r102 = r100.getInt(r100.getColumnIndex(DBDefinition.ID));     // Catch: Exception -> L8
        if (r102 <= 0) goto L6;
        r101.coverUri = ContentUris.withAppendedId(f447757a, r102);     // Catch: Exception -> L8
    L6:
        r101.dateTaken = r100.getLong(r100.getColumnIndex("datetaken"));     // Catch: Exception -> L8
        r101.mimeType = r100.getString(r100.getColumnIndex("mime_type"));     // Catch: Exception -> L8
        r101.setImgPath(r100.getString(r100.getColumnIndex("_data")));     // Catch: Exception -> L8
    L7:
        return r101;
    }

    public static List<MediaInfo> b(Context r210, int r211, boolean r212) {
        if (r210 == null) goto L5;
        if (r212 == false) goto L8;
        String r110 = null;
    L10:
        if (r212 == false) goto L12;
        String[] r111 = null;
    L13:
        HashMap r112 = new HashMap();
        HashMap r113 = new HashMap();
        long r100 = System.currentTimeMillis();
        Cursor r114 = sf7.a.f541727a.query(r210.getContentResolver(), f447758b, f447764h, null, null, null, com.ss.android.lark.widget.photopicker.entity.d.f447521a);     // Catch: Exception -> L22
        if (r114 == null) goto L23;
        r114.moveToFirst();     // Catch: Exception -> L22
    L18:
        if (r114.isAfterLast() == true) goto L20;
        int r115 = r114.getInt(r114.getColumnIndex("image_id"));     // Catch: Exception -> L22
        int r101 = r114.getInt(r114.getColumnIndex(DBDefinition.ID));     // Catch: Exception -> L22
        r112.put(Integer.valueOf(r115), r114.getString(r114.getColumnIndex("_data")));     // Catch: Exception -> L22
        r113.put(Integer.valueOf(r115), Integer.valueOf(r101));     // Catch: Exception -> L22
        r114.moveToNext();     // Catch: Exception -> L22
        goto L18
    L20:
        r114.close();     // Catch: Exception -> L22
        Logger.d("AlbumHelper", "ThumbImage isAll = true, image num = " + r114.getCount() + ", spend time = " + (System.currentTimeMillis() - r100));     // Catch: Exception -> L22
    L23:
        long r102 = System.currentTimeMillis();
        HashMap r213 = r113;
        HashMap r214 = r112;
        Cursor r103 = sf7.a.f541727a.query(r210.getContentResolver(), f447757a, f447763g, r110, r111, "date_modified DESC", com.ss.android.lark.widget.photopicker.entity.d.f447521a);     // Catch: Exception -> L28
    L33:
        ArrayList r104 = new ArrayList();
        if (r103 == null) goto L52;
        r103.moveToFirst();
    L37:
        if (r103.isAfterLast() == true) goto L51;
        ImageInfo r105 = new ImageInfo();
        r105.setId(r103.getInt(r103.getColumnIndex(DBDefinition.ID)));     // Catch: Exception -> L41
        r105.setImagePath(r103.getString(r103.getColumnIndex("_data")));     // Catch: Exception -> L41
        r105.setDateTaken(r103.getLong(r103.getColumnIndex("datetaken")));     // Catch: Exception -> L41
        r105.setMimeType(r103.getString(r103.getColumnIndex("mime_type")));     // Catch: Exception -> L41
        r105.setSize(r103.getLong(r103.getColumnIndex("_size")));     // Catch: Exception -> L41
    L42:
        String r106 = r105.getShowImagePath();
        if (TextUtils.isEmpty(r106) == false) goto L45;
    L47:
        boolean r107 = false;
    L48:
        if (r107 == false) goto L50;
        r104.add(r105);
    L50:
        r103.moveToNext();
        goto L37
    L45:
        if (new PolarisFileWrapper(r106).exists() == false) goto L47;
        r107 = true;
        goto L48
    L51:
        Logger.d("AlbumHelper", "Image isAll = " + r212 + ", image num = " + r103.getCount() + ", spend time = " + (System.currentTimeMillis() - r102));
        r103.close();
    L53:
        int r108 = 0;
    L62:
    L60:
        Log.e("AlbumHelper", "get image exception");
    L61:
        return r104;
    L55:
        if (r108 >= r104.size()) goto L61;
        MediaInfo r109 = (MediaInfo) ListProtector.get(r104, r108);     // Catch: Exception -> L60
        int r116 = r109.getId();     // Catch: Exception -> L60
        HashMap r117 = r214;
        r109.setThumbImagePath((String) r117.get(Integer.valueOf(r116)));     // Catch: Exception -> L60
        HashMap r118 = r213;
        Integer r119 = (Integer) r118.get(Integer.valueOf(r116));     // Catch: Exception -> L60
        if (r119 == null) goto L59;
        r109.thumbId = r119.intValue();     // Catch: Exception -> L60
    L59:
        r108 = r108 + 1;
        r213 = r118;
        r214 = r117;
        goto L62
    L52:
        Log.e("AlbumHelper", "getImage, cursor is null");
    L28:
        e = e;
    L32:
        Log.e("AlbumHelper", e.getMessage());
        r103 = null;
    L30:
        e = e;
        r213 = r113;
        r214 = r112;
    L22:
        Logger.d("AlbumHelper", "ThumbImage isAll = true, image num = " + r112.size() + ", spend time = " + (System.currentTimeMillis() - r100));
        goto L23
    L12:
        r111 = new String[]{String.valueOf(r211)};
        goto L13
    L8:
        r110 = "bucket_id = ?";
        goto L10
    L5:
        return new ArrayList();
    }

    public static List<MediaInfo> c(Context r210, int r211, boolean r212) {
        if (r210 == null) goto L5;
        Cursor r100 = null;
        if (r212 == false) goto L9;
        String r101 = null;
    L10:
        int r110 = 0;
        if (r212 == false) goto L13;
        String[] r111 = null;
    L14:
        HashMap r112 = new HashMap();
        HashMap r113 = new HashMap();
        Cursor r102 = sf7.a.f541727a.query(r210.getContentResolver(), f447760d, f447765i, null, null, null, com.ss.android.lark.widget.photopicker.entity.d.f447521a);     // Catch: Exception -> L23
        if (r102 == null) goto L58;
        r102.moveToFirst();     // Catch: Exception -> L23
    L19:
        if (r102.isAfterLast() == true) goto L21;
        int r103 = r102.getInt(r102.getColumnIndex("video_id"));     // Catch: Exception -> L23
        int r104 = r102.getInt(r102.getColumnIndex(DBDefinition.ID));     // Catch: Exception -> L23
        r112.put(Integer.valueOf(r103), r102.getString(r102.getColumnIndex("_data")));     // Catch: Exception -> L23
        r113.put(Integer.valueOf(r103), Integer.valueOf(r104));     // Catch: Exception -> L23
        r102.moveToNext();     // Catch: Exception -> L23
        goto L19
    L21:
        r102.close();     // Catch: Exception -> L23
    L58:
        r100 = sf7.a.f541727a.query(r210.getContentResolver(), f447759c, new String[]{DBDefinition.ID, "_data", "mime_type", "duration", "_size", "resolution", "datetaken", "width", "height"}, r101, r111, "date_modified DESC", com.ss.android.lark.widget.photopicker.entity.d.f447521a);     // Catch: Exception -> L26
    L28:
        if (r100 == null) goto L43;
        ArrayList r105 = new ArrayList(r100.getCount());
        r100.moveToFirst();
    L31:
        if (r100.isAfterLast() == true) goto L42;
        VideoInfo r106 = new VideoInfo();
        r106.setId(r100.getInt(r100.getColumnIndex(DBDefinition.ID)));     // Catch: Exception -> L35
        r106.setVideoPath(r100.getString(r100.getColumnIndex("_data")));     // Catch: Exception -> L35
        r106.setMimeType(r100.getString(r100.getColumnIndex("mime_type")));     // Catch: Exception -> L35
        r106.setDuration(r100.getLong(r100.getColumnIndex("duration")));     // Catch: Exception -> L35
        r106.setSize(r100.getLong(r100.getColumnIndex("_size")));     // Catch: Exception -> L35
        r106.setResolution(r100.getString(r100.getColumnIndex("resolution")));     // Catch: Exception -> L35
        r106.setDateTaken(r100.getLong(r100.getColumnIndex("datetaken")));     // Catch: Exception -> L35
        r106.setImageWidth(r100.getInt(r100.getColumnIndex("width")));     // Catch: Exception -> L35
        r106.setImageHeight(r100.getInt(r100.getColumnIndex("height")));     // Catch: Exception -> L35
    L37:
        if (VideoInfo.access$600(r106) == null) goto L41;
        if (new PolarisFileWrapper(VideoInfo.access$600(r106)).exists() == false) goto L41;
        r105.add(r106);
    L41:
        r100.moveToNext();
        goto L31
    L42:
        r100.close();
        List<MediaInfo> r107 = r105;
    L54:
    L50:
        Log.e("AlbumHelper", "video cursor exception");
    L51:
        return r107;
    L45:
        if (r110 >= r107.size()) goto L51;
        MediaInfo r108 = (MediaInfo) ListProtector.get(r107, r110);     // Catch: Exception -> L50
        int r109 = r108.getId();     // Catch: Exception -> L50
        r108.setThumbImagePath((String) r112.get(Integer.valueOf(r109)));     // Catch: Exception -> L50
        Integer r114 = (Integer) r113.get(Integer.valueOf(r109));     // Catch: Exception -> L50
        if (r114 == null) goto L49;
        r108.thumbId = r114.intValue();     // Catch: Exception -> L50
    L49:
        r110 = r110 + 1;
        goto L54
    L43:
        Log.e("AlbumHelper", "getVideo, cursor is null");
        r107 = Collections.emptyList();
    L26:
        e = move-exception;
        Log.e("AlbumHelper", e.getMessage());
    L23:
        Log.e("AlbumHelper", "thumbCursor exception");
        goto L58
    L13:
        r111 = new String[]{String.valueOf(r211)};
        goto L14
    L9:
        r101 = "bucket_id = ?";
        goto L10
    L5:
        return new ArrayList();
    }
}
