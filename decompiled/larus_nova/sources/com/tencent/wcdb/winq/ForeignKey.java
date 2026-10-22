package com.tencent.wcdb.winq;

import com.tencent.wcdb.base.CppObject;
import r27.a;

/* JADX INFO: loaded from: classes41.dex */
public class ForeignKey extends Identifier {

    public static final enum Action extends Enum<Action> {
        private static final /* synthetic */ Action[] $VALUES = null;
        public static final Action Cascade = null;
        public static final Action NoAction = null;
        public static final Action Restrict = null;
        public static final Action SetDefault = null;
        public static final Action SetNull = null;

        private static /* synthetic */ Action[] $values() {
            return new Action[]{SetNull, SetDefault, Cascade, Restrict, NoAction};
        }

        static {
            SetNull = new Action("SetNull", 0);
            SetDefault = new Action("SetDefault", 1);
            Cascade = new Action("Cascade", 2);
            Restrict = new Action("Restrict", 3);
            NoAction = new Action("NoAction", 4);
            $VALUES = $values();
        }

        public static Action[] values() {
            return (Action[]) $VALUES.clone();
        }

        public static Action valueOf(String r100) {
            return (Action) a.a(Action.class, r100);
        }

        private Action(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum Initially extends Enum<Initially> {
        private static final /* synthetic */ Initially[] $VALUES = null;
        public static final Initially Default = null;
        public static final Initially Deferred = null;
        public static final Initially Immediate = null;

        private static /* synthetic */ Initially[] $values() {
            return new Initially[]{Default, Deferred, Immediate};
        }

        static {
            Default = new Initially("Default", 0);
            Deferred = new Initially("Deferred", 1);
            Immediate = new Initially("Immediate", 2);
            $VALUES = $values();
        }

        public static Initially[] values() {
            return (Initially[]) $VALUES.clone();
        }

        public static Initially valueOf(String r100) {
            return (Initially) a.a(Initially.class, r100);
        }

        private Initially(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum Match extends Enum<Match> {
        private static final /* synthetic */ Match[] $VALUES = null;
        public static final Match Full = null;
        public static final Match Partial = null;
        public static final Match Simple = null;

        private static /* synthetic */ Match[] $values() {
            return new Match[]{Simple, Full, Partial};
        }

        static {
            Simple = new Match("Simple", 0);
            Full = new Match("Full", 1);
            Partial = new Match("Partial", 2);
            $VALUES = $values();
        }

        public static Match[] values() {
            return (Match[]) $VALUES.clone();
        }

        public static Match valueOf(String r100) {
            return (Match) a.a(Match.class, r100);
        }

        private Match(String r100, int r101) {
            super(r100, r101);
        }
    }

    private static native void configColumns(long r100, int r101, long[] r102, String[] r103);

    private static native void configDeferrable(long r100, int r101);

    private static native void configMatch(long r100, int r101);

    private static native void configNotDeferrable(long r100, int r101);

    private static native void configOnDeleteAction(long r100, int r101);

    private static native void configOnUpdateAction(long r100, int r101);

    private static native void configReference(long r100, String r101);

    private static native long createCPPObj();

    @Override // com.tencent.wcdb.winq.Identifier
    public int getType() {
        return 13;
    }

    public ForeignKey() {
        this.cppObj = createCPPObj();
    }

    public ForeignKey column(Column r100) {
        configColumns(this.cppObj, Identifier.getCppType(r100), new long[]{CppObject.get(r100)}, null);
        return this;
    }

    public ForeignKey columns(Column... r100) {
        if (r100 != null) goto L4;
    L11:
        return this;
    L4:
        if (r100.length == 0) goto L11;
        long[] r101 = new long[r100.length];
        int r102 = 0;
    L8:
        if (r102 >= r100.length) goto L10;
        r101[r102] = CppObject.get(r100[r102]);
        r102 = r102 + 1;
        goto L8
    L10:
        configColumns(this.cppObj, 7, r101, null);
        goto L11
    }

    public ForeignKey deferrable(Initially r100) {
        configDeferrable(this.cppObj, r100.ordinal());
        return this;
    }

    public ForeignKey match(Match r100) {
        configMatch(this.cppObj, r100.ordinal() + 1);
        return this;
    }

    public ForeignKey notDeferrable(Initially r100) {
        configNotDeferrable(this.cppObj, r100.ordinal());
        return this;
    }

    public ForeignKey onDelete(Action r100) {
        configOnDeleteAction(this.cppObj, r100.ordinal());
        return this;
    }

    public ForeignKey onUpdate(Action r100) {
        configOnUpdateAction(this.cppObj, r100.ordinal());
        return this;
    }

    public ForeignKey references(String r100) {
        configReference(this.cppObj, r100);
        return this;
    }

    public ForeignKey column(String r100) {
        configColumns(this.cppObj, 6, null, new String[]{r100});
        return this;
    }

    public ForeignKey columns(String... r100) {
        if (r100 != null) goto L4;
    L7:
        return this;
    L4:
        if (r100.length == 0) goto L7;
        configColumns(this.cppObj, 6, null, r100);
        goto L7
    }
}
