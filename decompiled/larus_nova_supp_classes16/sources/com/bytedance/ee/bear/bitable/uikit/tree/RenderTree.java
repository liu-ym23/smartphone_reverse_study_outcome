package com.bytedance.ee.bear.bitable.uikit.tree;

import android.text.TextUtils;
import com.bytedance.ee.util.io.NonProguard;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import ct4.d;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 P2\u00020\u0001:\u0001PB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u00100\u001a\u0002012\b\b\u0002\u00102\u001a\u00020\u001aJ\u0006\u00103\u001a\u00020\u001aJ\u0006\u00104\u001a\u000205J\u0016\u00106\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u000007J(\u00108\u001a\b\u0012\u0004\u0012\u00020\u0005092\u0006\u0010:\u001a\u00020;2\b\b\u0002\u0010<\u001a\u0002052\b\b\u0002\u0010=\u001a\u00020\u001aJ\u0014\u0010>\u001a\b\u0012\u0004\u0012\u00020%092\u0006\u0010?\u001a\u00020%J \u0010@\u001a\b\u0012\u0004\u0012\u00020\u0005092\u0006\u0010:\u001a\u00020;2\b\b\u0002\u0010<\u001a\u000205H\u0002J\u000e\u0010A\u001a\u0002012\u0006\u0010B\u001a\u00020\u001aJ\u0010\u0010C\u001a\u0004\u0018\u00010\u00002\u0006\u0010D\u001a\u00020%J\u001e\u0010E\u001a\u00020\u001a2\u0006\u0010F\u001a\u00020%2\u0006\u0010G\u001a\u00020%2\u0006\u0010H\u001a\u000205J3\u0010B\u001a\u0002012!\u0010I\u001a\u001d\u0012\u0013\u0012\u00110%¢\u0006\f\bK\u0012\b\bL\u0012\u0004\b\b(?\u0012\u0004\u0012\u00020\u001a0J2\b\b\u0002\u00102\u001a\u00020\u001aJ\b\u0010M\u001a\u000201H\u0002J\b\u0010N\u001a\u000201H\u0002J\b\u0010O\u001a\u000201H\u0002R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR.\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\u0000\u0018\u0001`\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R*\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u000bj\b\u0012\u0004\u0012\u00020\u0005`\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0000X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001e\u0010 \u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b!\u0010\u001c\"\u0004\b\"\u0010\u001eR.\u0010#\u001a\u0016\u0012\u0004\u0012\u00020%\u0018\u00010$j\n\u0012\u0004\u0012\u00020%\u0018\u0001`&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001a\u0010+\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/¨\u0006Q"}, d2 = {"Lcom/bytedance/ee/bear/bitable/uikit/tree/RenderTree;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "current", "Lcom/bytedance/ee/bear/bitable/uikit/tree/RenderItem;", "getCurrent", "()Lcom/bytedance/ee/bear/bitable/uikit/tree/RenderItem;", "setCurrent", "(Lcom/bytedance/ee/bear/bitable/uikit/tree/RenderItem;)V", "children", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getChildren", "()Ljava/util/ArrayList;", "setChildren", "(Ljava/util/ArrayList;)V", "renderItemList", "getRenderItemList", "setRenderItemList", "parent", "getParent", "()Lcom/bytedance/ee/bear/bitable/uikit/tree/RenderTree;", "setParent", "(Lcom/bytedance/ee/bear/bitable/uikit/tree/RenderTree;)V", "searchMark", "", "getSearchMark", "()Ljava/lang/Boolean;", "setSearchMark", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "inSearch", "getInSearch", "setInSearch", "searchCollapsedSet", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "getSearchCollapsedSet", "()Ljava/util/HashSet;", "setSearchCollapsedSet", "(Ljava/util/HashSet;)V", "parentDirty", "getParentDirty", "()Z", "setParentDirty", "(Z)V", "checkTreeParent", "", "recursion", "isRoot", "getDepth", "", "getBothersInSameLevel", "Lkotlin/Pair;", "genRenderItemList", "", "collapsedSet", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/ICollapsedSet;", "currentLevel", "searchRecursion", "getParentIdList", "id", "genRenderItemListInSearch", "toggleSearchState", "search", "findTree", "itemId", "moveTree", "fromId", "toId", "offsetLevel", "condition", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "clearMark", "markParent", "markChildren", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class RenderTree implements NonProguard {
    public static final a Companion = null;
    private static String ROOT;
    private static String TAG;
    private ArrayList<RenderTree> children;
    private RenderItem current;
    private Boolean inSearch;
    private RenderTree parent;
    private boolean parentDirty;
    private ArrayList<RenderItem> renderItemList;
    private HashSet<String> searchCollapsedSet;
    private Boolean searchMark;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
        TAG = "RenderTree";
        ROOT = "root";
    }

    private final void clearMark() {
        this.searchMark = Boolean.FALSE;
        ArrayList<RenderTree> r0 = this.children;
        if (r0 == null) goto L8;
        Iterator<T> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        ((RenderTree) r1.next()).clearMark();
        goto L6
    L10:
        return;
    }

    private final void markChildren() {
        ArrayList<RenderTree> r0 = this.children;
        if (r0 == null) goto L8;
        Iterator<T> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        RenderTree r2 = (RenderTree) r1.next();
        r2.searchMark = Boolean.TRUE;
        r2.markChildren();
        goto L6
    L10:
        return;
    }

    private final void markParent() {
        RenderTree r0 = this.parent;
    L3:
        if (r0 == null) goto L5;
        r0.searchMark = Boolean.TRUE;
        r0 = r0.parent;
        goto L3
    }

    public final Pair<RenderTree, RenderTree> getBothersInSameLevel() {
        RenderTree r0 = this.parent;
        if (r0 == null) goto L7;
        ArrayList<RenderTree> r1 = r0.children;
        if (r1 == null) goto L7;
        int r2 = r1.indexOf(this);
    L8:
        RenderTree r3 = this.parent;
        RenderTree r4 = null;
        if (r3 == null) goto L23;
        ArrayList<RenderTree> r5 = r3.children;
        if (r5 == null) goto L23;
        if (r2 < 0) goto L23;
        int r6 = r2 - 1;
        if (r6 < 0) goto L16;
        RenderTree r7 = (RenderTree) ListProtector.get(r5, r6);
    L17:
        int r8 = r2 + 1;
        if (r8 >= r5.size()) goto L21;
        r4 = (RenderTree) ListProtector.get(r5, r8);
    L21:
        return new Pair(r7, r4);
    L16:
        r7 = null;
    L23:
        return new Pair(null, null);
    L7:
        r2 = -1;
        goto L8
    }

    public final int getDepth() {
        ArrayList<RenderTree> r0 = this.children;
        int r1 = 0;
        if (r0 == null) goto L8;
        Iterator<T> r2 = r0.iterator();
    L6:
        if (r2.hasNext() == false) goto L8;
        r1 = Math.max(r1, ((RenderTree) r2.next()).getDepth());
    L8:
        RenderItem r3 = this.current;
        if (r3 == null) goto L11;
        String r4 = r3.getType();
    L13:
        if (TextUtils.equals(r4, "BITABLE_FOLDER") == false) goto L17;
        return Math.max(1, r1) + 1;
    L17:
        return r1 + 1;
    L11:
        r4 = null;
        goto L13
    }

    public final boolean isRoot() {
        RenderItem r0 = this.current;
        if (r0 == null) goto L5;
        String r1 = r0.getId();
    L7:
        return TextUtils.equals(r1, ROOT);
    L5:
        r1 = null;
        goto L7
    }

    public RenderTree() {
        this.renderItemList = new ArrayList();
        this.parentDirty = true;
    }

    public static final /* synthetic */ String access$getROOT$cp() {
        return ROOT;
    }

    public static final /* synthetic */ String access$getTAG$cp() {
        return TAG;
    }

    public final ArrayList<RenderTree> getChildren() {
        return this.children;
    }

    public final RenderItem getCurrent() {
        return this.current;
    }

    public final Boolean getInSearch() {
        return this.inSearch;
    }

    public final RenderTree getParent() {
        return this.parent;
    }

    public final boolean getParentDirty() {
        return this.parentDirty;
    }

    public final ArrayList<RenderItem> getRenderItemList() {
        return this.renderItemList;
    }

    public final HashSet<String> getSearchCollapsedSet() {
        return this.searchCollapsedSet;
    }

    public final Boolean getSearchMark() {
        return this.searchMark;
    }

    public static final /* synthetic */ void access$setROOT$cp(String r0) {
        ROOT = r0;
    }

    public static final /* synthetic */ void access$setTAG$cp(String r0) {
        TAG = r0;
    }

    public final void checkTreeParent(boolean r3) {
        if (this.parentDirty == true) goto L5;
        if (r3 == true) goto L5;
        return;
    L5:
        this.parentDirty = false;
        ArrayList<RenderTree> r4 = this.children;
        if (r4 == null) goto L13;
        Iterator<T> r5 = r4.iterator();
    L9:
        if (r5.hasNext() == false) goto L14;
        RenderTree r0 = (RenderTree) r5.next();
        r0.parent = this;
        r0.checkTreeParent(true);
        goto L9
    L14:
        return;
    }

    public final RenderTree findTree(String r4) {
        Intrinsics.checkNotNullParameter(r4, "itemId");
        RenderItem r0 = this.current;
        if (r0 == null) goto L5;
        String r1 = r0.getId();
    L7:
        if (TextUtils.equals(r1, r4) == false) goto L9;
        return this;
    L9:
        ArrayList<RenderTree> r2 = this.children;
        if (r2 == null) goto L17;
        Iterator<T> r3 = r2.iterator();
    L13:
        if (r3.hasNext() == false) goto L17;
        RenderTree r5 = ((RenderTree) r3.next()).findTree(r4);
        if (r5 == null) goto L13;
        return r5;
    L17:
        return null;
    L5:
        r1 = null;
        goto L7
    }

    public final List<String> getParentIdList(String r4) {
        Intrinsics.checkNotNullParameter(r4, "id");
        checkTreeParent$default(this, false, 1, null);
        ArrayList r0 = new ArrayList();
        RenderTree r5 = findTree(r4);
    L3:
        if (r5 == null) goto L10;
        RenderItem r1 = r5.current;
        if (r1 == null) goto L9;
        String r2 = r1.getId();
        if (r2 == null) goto L9;
        r0.add(r2);
    L9:
        r5 = r5.parent;
        goto L3
    L10:
        return r0;
    }

    public final void setChildren(ArrayList<RenderTree> r1) {
        this.children = r1;
    }

    public final void setCurrent(RenderItem r1) {
        this.current = r1;
    }

    public final void setInSearch(Boolean r1) {
        this.inSearch = r1;
    }

    public final void setParent(RenderTree r1) {
        this.parent = r1;
    }

    public final void setParentDirty(boolean r1) {
        this.parentDirty = r1;
    }

    public final void setRenderItemList(ArrayList<RenderItem> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.renderItemList = r2;
    }

    public final void setSearchCollapsedSet(HashSet<String> r1) {
        this.searchCollapsedSet = r1;
    }

    public final void setSearchMark(Boolean r1) {
        this.searchMark = r1;
    }

    public final void toggleSearchState(boolean r1) {
        this.inSearch = Boolean.valueOf(r1);
    }

    private final List<RenderItem> genRenderItemListInSearch(d r6, int r7) {
        ArrayList<RenderItem> r0 = new ArrayList();
        if (Intrinsics.areEqual(this.searchMark, Boolean.TRUE) == false) goto L10;
        RenderItem r1 = this.current;
        if (r1 == null) goto L10;
        if (isRoot() == true) goto L10;
        r0.add(r1);
    L10:
        if (isRoot() == true) goto L24;
        RenderItem r2 = this.current;
        if (r2 == null) goto L14;
        String r3 = r2.getId();
    L16:
        if (TextUtils.isEmpty(r3) == true) goto L30;
        RenderItem r4 = this.current;
        if (r4 == null) goto L21;
        String r5 = r4.getId();
        if (r5 == null) goto L21;
    L23:
        if (r6.q(r5) == true) goto L30;
    L21:
        r5 = "";
    L30:
        this.renderItemList = r0;
        return r0;
    L14:
        r3 = null;
    L24:
        ArrayList<RenderTree> r8 = this.children;
        if (r8 == null) goto L30;
        Iterator<T> r9 = r8.iterator();
    L28:
        if (r9.hasNext() == false) goto L30;
        r0.addAll(((RenderTree) r9.next()).genRenderItemList(r6, r7 + 1, true));
        goto L28
    }

    public final void search(Function1<? super String, Boolean> r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r4, "condition");
        Boolean r2 = null;
        checkTreeParent$default(this, false, 1, null);
        if (r5 == true) goto L5;
        clearMark();
    L5:
        RenderItem r6 = this.current;
        if (r6 == null) goto L8;
        r2 = Boolean.valueOf(((Boolean) r4.invoke(r6.getId())).booleanValue());
    L8:
        Boolean r7 = Boolean.TRUE;
        if (Intrinsics.areEqual(r2, r7) == false) goto L11;
        markParent();
        markChildren();
        this.searchMark = r7;
    L11:
        ArrayList<RenderTree> r8 = this.children;
        if (r8 == null) goto L17;
        Iterator<T> r9 = r8.iterator();
    L15:
        if (r9.hasNext() == false) goto L19;
        ((RenderTree) r9.next()).search(r4, true);
        goto L15
    L19:
        return;
    }

    public final List<RenderItem> genRenderItemList(d r9, int r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r9, "collapsedSet");
        if (Intrinsics.areEqual(this.inSearch, Boolean.TRUE) == true) goto L35;
        if (r11 == true) goto L35;
        ArrayList<RenderItem> r12 = new ArrayList();
        RenderItem r0 = this.current;
        if (r0 == null) goto L12;
        r0.setLevel(r10);
        if (isRoot() == true) goto L12;
        r12.add(r0);
    L12:
        if (isRoot() == true) goto L26;
        RenderItem r1 = this.current;
        if (r1 == null) goto L16;
        String r2 = r1.getId();
    L18:
        if (TextUtils.isEmpty(r2) == true) goto L32;
        RenderItem r3 = this.current;
        if (r3 == null) goto L23;
        String r4 = r3.getId();
        if (r4 == null) goto L23;
    L25:
        if (r9.q(r4) == true) goto L32;
    L23:
        r4 = "";
    L32:
        this.renderItemList = r12;
        return r12;
    L16:
        r2 = null;
    L26:
        ArrayList<RenderTree> r5 = this.children;
        if (r5 == null) goto L32;
        Iterator<T> r6 = r5.iterator();
    L30:
        if (r6.hasNext() == false) goto L32;
        r12.addAll(genRenderItemList$default((RenderTree) r6.next(), r9, r10 + 1, false, 4, null));
    L35:
        return genRenderItemListInSearch(r9, r10);
    }

    public final boolean moveTree(String r11, String r12, int r13) {
        Intrinsics.checkNotNullParameter(r11, "fromId");
        Intrinsics.checkNotNullParameter(r12, "toId");
        int r0 = 0;
        checkTreeParent$default(this, false, 1, null);
        tt5.a.d(TAG, "moveTree fromId:" + r11 + ". toId: " + r12 + ". offsetLevel:" + r13);
        RenderTree r3 = findTree(r11);
        if (r3 != null) goto L6;
        tt5.a.d(TAG, "findSourceTree error.");
        return false;
    L6:
        RenderTree r4 = findTree(r12);
        if (r4 != null) goto L10;
        tt5.a.d(TAG, "findTargetTree error.");
        return false;
    L10:
        RenderTree r5 = r3.parent;
        if (r5 == null) goto L70;
        ArrayList<RenderTree> r6 = r5.children;
        if (r6 == null) goto L70;
        Iterator<RenderTree> r7 = r6.iterator();
        int r8 = 0;
    L15:
        int r9 = -1;
        if (r7.hasNext() == false) goto L25;
        RenderItem r10 = r7.next().current;
        if (r10 == null) goto L20;
        String r14 = r10.getId();
    L22:
        if (TextUtils.equals(r14, r11) == true) goto L26;
        r8 = r8 + 1;
    L26:
        RenderTree r16 = null;
    L27:
        if (r13 >= 1) goto L33;
        RenderTree r17 = r4.parent;
        if (r17 == null) goto L30;
        r13 = r13 + 1;
        RenderTree r18 = r4;
        r4 = r17;
        r16 = r18;
        goto L27
    L30:
        tt5.a.d(TAG, "findTargetTreeByOffsetLevel error.");
        return false;
    L33:
        RenderTree r19 = r3.parent;
        if (r19 == null) goto L68;
        ArrayList<RenderTree> r110 = r19.children;
        if (r110 == null) goto L68;
        RenderTree r111 = (RenderTree) ListProtector.remove(r110, r8);
        if (r111 == null) goto L68;
        if (r16 == null) goto L63;
        RenderItem r112 = r16.current;
        if (r112 == null) goto L47;
        String r113 = r112.getId();
        if (r113 == null) goto L47;
        r12 = r113;
    L47:
        ArrayList<RenderTree> r114 = r4.children;
        if (r114 == null) goto L61;
        Iterator<RenderTree> r115 = r114.iterator();
    L51:
        if (r115.hasNext() == false) goto L60;
        RenderItem r20 = r115.next().current;
        if (r20 == null) goto L55;
        String r21 = r20.getId();
    L57:
        if (TextUtils.equals(r21, r12) == true) goto L58;
        r0 = r0 + 1;
        goto L51
    L58:
        r9 = r0;
        goto L60
    L55:
        r21 = null;
    L60:
        r0 = r9 + 1;
        goto L63
    L61:
        tt5.a.d(TAG, "findTargetIndex error.");
        return false;
    L63:
        ArrayList<RenderTree> r116 = r4.children;
        if (r116 == null) goto L66;
        ListProtector.add(r116, r0, r111);
    L66:
        r111.parent = r4;
        return true;
    L68:
        tt5.a.d(TAG, "removeItem empty.");
        return false;
    L20:
        r14 = null;
        goto L22
    L25:
        r8 = -1;
    L70:
        tt5.a.d(TAG, "findSourceIndex error.");
        return false;
    }

    public static /* synthetic */ void checkTreeParent$default(RenderTree r0, boolean r1, int r2, Object r3) {
        if (r3 != null) goto L9;
        if ((r2 & 1) == 0) goto L6;
        r1 = false;
    L6:
        r0.checkTreeParent(r1);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: checkTreeParent");
    }

    public static /* synthetic */ List genRenderItemListInSearch$default(RenderTree r0, d r1, int r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 2) == 0) goto L7;
        r2 = 1;
    L7:
        return r0.genRenderItemListInSearch(r1, r2);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: genRenderItemListInSearch");
    }

    public static /* synthetic */ void search$default(RenderTree r0, Function1 r1, boolean r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 2) == 0) goto L6;
        r2 = false;
    L6:
        r0.search(r1, r2);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: search");
    }

    public static /* synthetic */ List genRenderItemList$default(RenderTree r1, d r2, int r3, boolean r4, int r5, Object r6) {
        if (r6 != null) goto L12;
        if ((r5 & 2) == 0) goto L7;
        r3 = 0;
    L7:
        if ((r5 & 4) == 0) goto L10;
        r4 = false;
    L10:
        return r1.genRenderItemList(r2, r3, r4);
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: genRenderItemList");
    }
}
