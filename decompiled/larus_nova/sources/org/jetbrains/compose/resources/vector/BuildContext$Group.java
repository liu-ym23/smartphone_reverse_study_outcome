package org.jetbrains.compose.resources.vector;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes42.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lorg/jetbrains/compose/resources/vector/BuildContext$Group;", "", "<init>", "(Ljava/lang/String;I)V", "Real", "Virtual", "library_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum BuildContext$Group extends Enum<BuildContext$Group> {
    public static final BuildContext$Group Real = null;
    public static final BuildContext$Group Virtual = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BuildContext$Group[] f525877a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f525878b = null;

    public static EnumEntries<BuildContext$Group> getEntries() {
        return f525878b;
    }

    static {
        BuildContext$Group r100 = new BuildContext$Group("Real", 0);
        Real = r100;
        BuildContext$Group r101 = new BuildContext$Group("Virtual", 1);
        Virtual = r101;
        BuildContext$Group[] r102 = {r100, r101};
        f525877a = r102;
        f525878b = EnumEntriesKt.enumEntries(r102);
    }

    public static BuildContext$Group[] values() {
        return (BuildContext$Group[]) f525877a.clone();
    }

    public static BuildContext$Group valueOf(String r100) {
        return (BuildContext$Group) a.a(BuildContext$Group.class, r100);
    }

    public BuildContext$Group(String r100, int r101) {
        super(r100, r101);
    }
}
