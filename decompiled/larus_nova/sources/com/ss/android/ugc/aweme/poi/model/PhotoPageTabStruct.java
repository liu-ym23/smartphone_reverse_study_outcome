package com.ss.android.ugc.aweme.poi.model;

import com.larus.bmhome.chat.bean.SuggestActionType;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/ss/android/ugc/aweme/poi/model/PhotoPageTabStruct;", "", "", "value", "I", "getValue", "()I", SuggestActionType.PHOTO, "VIDEO", "LYNX", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3})
public final enum PhotoPageTabStruct extends Enum<PhotoPageTabStruct> {
    public static final PhotoPageTabStruct LYNX = null;
    public static final PhotoPageTabStruct PHOTO = null;
    public static final PhotoPageTabStruct VIDEO = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PhotoPageTabStruct[] f451355a = null;
    private final int value;

    public static PhotoPageTabStruct valueOf(String r100) {
        return (PhotoPageTabStruct) a.a(PhotoPageTabStruct.class, r100);
    }

    public static PhotoPageTabStruct[] values() {
        return (PhotoPageTabStruct[]) f451355a.clone();
    }

    static {
        PhotoPageTabStruct r100 = new PhotoPageTabStruct(SuggestActionType.PHOTO, 0, 1);
        PHOTO = r100;
        PhotoPageTabStruct r101 = new PhotoPageTabStruct("VIDEO", 1, 2);
        VIDEO = r101;
        PhotoPageTabStruct r102 = new PhotoPageTabStruct("LYNX", 2, 3);
        LYNX = r102;
        f451355a = new PhotoPageTabStruct[]{r100, r101, r102};
    }

    public final int getValue() {
        return this.value;
    }

    public PhotoPageTabStruct(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
