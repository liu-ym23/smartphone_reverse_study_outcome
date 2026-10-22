package com.ss.android.lark.biz.im.api;

import com.ss.android.lark.chat.entity.image.ImageSet;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes34.dex */
public class ImageHistoryResponse implements Serializable {
    private boolean hasMoreAfter;
    private boolean hasMoreBefore;
    private List<ImageSet> imageSetList;

    public static final enum Direction extends Enum<Direction> {
        public static final Direction AFTER = null;
        public static final Direction BEFORE = null;
        public static final Direction BIDIRECT = null;
        public static final Direction UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Direction[] f409870a = null;
        private int value;

        static {
            Direction r100 = new Direction("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            Direction r101 = new Direction("BEFORE", 1, 1);
            BEFORE = r101;
            Direction r102 = new Direction("AFTER", 2, 2);
            AFTER = r102;
            Direction r103 = new Direction("BIDIRECT", 3, 3);
            BIDIRECT = r103;
            f409870a = new Direction[]{r100, r101, r102, r103};
        }

        public static Direction[] values() {
            return (Direction[]) f409870a.clone();
        }

        public int getNumber() {
            return this.value;
        }

        public static Direction forNumber(int r100) {
            if (r100 == 1) goto L15;
            if (r100 == 2) goto L13;
            if (r100 == 3) goto L11;
            return UNKNOWN;
        L11:
            return BIDIRECT;
        L13:
            return AFTER;
        L15:
            return BEFORE;
        }

        public static Direction valueOf(String r100) {
            return (Direction) r27.a.a(Direction.class, r100);
        }

        public static Direction valueOf(int r100) {
            return forNumber(r100);
        }

        public Direction(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum ResourceType extends Enum<ResourceType> {
        public static final ResourceType IMAGE = null;
        public static final ResourceType UNKNOWN = null;
        public static final ResourceType VIDEO = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ResourceType[] f409871a = null;
        private int value;

        static {
            ResourceType r100 = new ResourceType("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            ResourceType r101 = new ResourceType("IMAGE", 1, 1);
            IMAGE = r101;
            ResourceType r102 = new ResourceType("VIDEO", 2, 2);
            VIDEO = r102;
            f409871a = new ResourceType[]{r100, r101, r102};
        }

        public static ResourceType[] values() {
            return (ResourceType[]) f409871a.clone();
        }

        public int getNumber() {
            return this.value;
        }

        public static ResourceType forNumber(int r100) {
            if (r100 == 1) goto L11;
            if (r100 == 2) goto L9;
            return UNKNOWN;
        L9:
            return VIDEO;
        L11:
            return IMAGE;
        }

        public static ResourceType valueOf(String r100) {
            return (ResourceType) r27.a.a(ResourceType.class, r100);
        }

        public static ResourceType valueOf(int r100) {
            return forNumber(r100);
        }

        public ResourceType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public ImageHistoryResponse() {
    }

    public List<ImageSet> getImageSetList() {
        return this.imageSetList;
    }

    public boolean isHasMoreAfter() {
        return this.hasMoreAfter;
    }

    public boolean isHasMoreBefore() {
        return this.hasMoreBefore;
    }

    public void setHasMoreAfter(boolean r100) {
        this.hasMoreAfter = r100;
    }

    public void setHasMoreBefore(boolean r100) {
        this.hasMoreBefore = r100;
    }

    public void setImageSetList(List<ImageSet> r100) {
        this.imageSetList = r100;
    }
}
