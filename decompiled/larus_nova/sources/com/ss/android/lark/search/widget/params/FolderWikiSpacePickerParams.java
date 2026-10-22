package com.ss.android.lark.search.widget.params;

import com.bytedance.lark.pb.basic.v1.Doc;
import com.ss.android.lark.picker.base.widget.params.BasePickerParams;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes38.dex */
public final class FolderWikiSpacePickerParams extends BasePickerParams {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Doc.Type> f440379a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PickerType f440380b;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/search/widget/params/FolderWikiSpacePickerParams$PickerType;", "", "<init>", "(Ljava/lang/String;I)V", "Folder", "WikiSpace", "search-widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum PickerType extends Enum<PickerType> {
        public static final PickerType Folder = null;
        public static final PickerType WikiSpace = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ PickerType[] f440381a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f440382b = null;

        public static EnumEntries<PickerType> getEntries() {
            return f440382b;
        }

        static {
            PickerType r100 = new PickerType("Folder", 0);
            Folder = r100;
            PickerType r101 = new PickerType("WikiSpace", 1);
            WikiSpace = r101;
            PickerType[] r102 = {r100, r101};
            f440381a = r102;
            f440382b = EnumEntriesKt.enumEntries(r102);
        }

        public static PickerType[] values() {
            return (PickerType[]) f440381a.clone();
        }

        public static PickerType valueOf(String r100) {
            return (PickerType) a.a(PickerType.class, r100);
        }

        public PickerType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public FolderWikiSpacePickerParams() {
        this.f440379a = new ArrayList();
        this.f440380b = PickerType.Folder;
    }
}
