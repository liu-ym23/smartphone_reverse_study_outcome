package io.noties.markwon.core;

import java.util.HashMap;
import java.util.Map;
import lsc.q;

/* JADX INFO: loaded from: classes41.dex */
public abstract class CoreProps {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q<ListItemType> f492259a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final q<Integer> f492260b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final q<Integer> f492261c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final q<Integer> f492262d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final q<Boolean> f492263e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final q<Integer> f492264f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final q<String> f492265g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final q<Map<String, String>> f492266h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final q<Boolean> f492267i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final q<HashMap<String, Integer>> f492268j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final q<String> f492269k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final q<String> f492270l = null;

    public static final enum ListItemType extends Enum<ListItemType> {
        public static final ListItemType BULLET = null;
        public static final ListItemType ORDERED = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ListItemType[] f492271a = null;

        static {
            ListItemType r100 = new ListItemType("BULLET", 0);
            BULLET = r100;
            ListItemType r101 = new ListItemType("ORDERED", 1);
            ORDERED = r101;
            f492271a = new ListItemType[]{r100, r101};
        }

        public static ListItemType[] values() {
            return (ListItemType[]) f492271a.clone();
        }

        public static ListItemType valueOf(String r100) {
            return (ListItemType) r27.a.a(ListItemType.class, r100);
        }

        public ListItemType(String r100, int r101) {
            super(r100, r101);
        }
    }

    static {
        f492259a = new q("list-item-type");
        f492260b = new q("bullet-list-item-level");
        f492261c = new q("list-item-real-level");
        f492262d = new q("ordered-list-item-number");
        f492263e = new q("list-item-real-self");
        f492264f = new q("heading-level");
        f492265g = new q("link-destination");
        f492266h = new q("link-extra");
        f492267i = new q("paragraph-is-in-tight-list");
        f492268j = new q("render_node_info");
        f492269k = new q("code-block-info");
        f492270l = new q("code-block-code");
    }
}
