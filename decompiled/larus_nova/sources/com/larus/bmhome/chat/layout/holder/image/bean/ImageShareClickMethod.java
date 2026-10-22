package com.larus.bmhome.chat.layout.holder.image.bean;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/bmhome/chat/layout/holder/image/bean/ImageShareClickMethod;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "OverviewClick", "LongPressMenuClick", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ImageShareClickMethod extends Enum<ImageShareClickMethod> {
    public static final ImageShareClickMethod LongPressMenuClick = null;
    public static final ImageShareClickMethod OverviewClick = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ImageShareClickMethod[] f303787a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f303788b = null;
    private final String value;

    public static EnumEntries<ImageShareClickMethod> getEntries() {
        return f303788b;
    }

    static {
        ImageShareClickMethod r100 = new ImageShareClickMethod("OverviewClick", 0, "overview_click");
        OverviewClick = r100;
        ImageShareClickMethod r101 = new ImageShareClickMethod("LongPressMenuClick", 1, "overview_long_press");
        LongPressMenuClick = r101;
        ImageShareClickMethod[] r102 = {r100, r101};
        f303787a = r102;
        f303788b = EnumEntriesKt.enumEntries(r102);
    }

    public static ImageShareClickMethod[] values() {
        return (ImageShareClickMethod[]) f303787a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static ImageShareClickMethod valueOf(String r100) {
        return (ImageShareClickMethod) a.a(ImageShareClickMethod.class, r100);
    }

    public ImageShareClickMethod(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
