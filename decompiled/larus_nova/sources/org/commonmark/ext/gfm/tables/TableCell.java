package org.commonmark.ext.gfm.tables;

import org.commonmark.node.CustomNode;
import r27.a;

/* JADX INFO: loaded from: classes5.dex */
public class TableCell extends CustomNode {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f525648h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Alignment f525649i;

    /* JADX INFO: loaded from: classes42.dex */
    public static final enum Alignment extends Enum<Alignment> {
        public static final Alignment CENTER = null;
        public static final Alignment LEFT = null;
        public static final Alignment RIGHT = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Alignment[] f525650a = null;

        static {
            Alignment r100 = new Alignment("LEFT", 0);
            LEFT = r100;
            Alignment r101 = new Alignment("CENTER", 1);
            CENTER = r101;
            Alignment r102 = new Alignment("RIGHT", 2);
            RIGHT = r102;
            f525650a = new Alignment[]{r100, r101, r102};
        }

        public static Alignment[] values() {
            return (Alignment[]) f525650a.clone();
        }

        public static Alignment valueOf(String r100) {
            return (Alignment) a.a(Alignment.class, r100);
        }

        public Alignment(String r100, int r101) {
            super(r100, r101);
        }
    }

    public TableCell() {
    }
}
