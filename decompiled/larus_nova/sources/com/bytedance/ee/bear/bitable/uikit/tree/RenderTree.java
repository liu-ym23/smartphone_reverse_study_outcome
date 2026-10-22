package com.bytedance.ee.bear.bitable.uikit.tree;

import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
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

/* JADX INFO: loaded from: classes16.dex */
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
        ROOT = RootDescription.ROOT_ELEMENT;
    }

    private final void clearMark() {
        this.searchMark = Boolean.FALSE;
        ArrayList<RenderTree> r100 = this.children;
        if (r100 == null) goto L8;
        Iterator<T> r101 = r100.iterator();
    L6:
        if (r101.hasNext() == false) goto L10;
        ((RenderTree) r101.next()).clearMark();
        goto L6
    L10:
        return;
    }

    private final void markChildren() {
        ArrayList<RenderTree> r100 = this.children;
        if (r100 == null) goto L8;
        Iterator<T> r101 = r100.iterator();
    L6:
        if (r101.hasNext() == false) goto L10;
        RenderTree r102 = (RenderTree) r101.next();
        r102.searchMark = Boolean.TRUE;
        r102.markChildren();
        goto L6
    L10:
        return;
    }

    private final void markParent() {
        RenderTree r100 = this.parent;
    L3:
        if (r100 == null) goto L5;
        r100.searchMark = Boolean.TRUE;
        r100 = r100.parent;
        goto L3
    }

    public final Pair<RenderTree, RenderTree> getBothersInSameLevel() {
        RenderTree r100 = this.parent;
        if (r100 == null) goto L7;
        ArrayList<RenderTree> r101 = r100.children;
        if (r101 == null) goto L7;
        int r102 = r101.indexOf(this);
    L8:
        RenderTree r103 = this.parent;
        RenderTree r104 = null;
        if (r103 == null) goto L23;
        ArrayList<RenderTree> r105 = r103.children;
        if (r105 == null) goto L23;
        if (r102 < 0) goto L23;
        int r106 = r102 - 1;
        if (r106 < 0) goto L16;
        RenderTree r107 = (RenderTree) ListProtector.get(r105, r106);
    L17:
        int r108 = r102 + 1;
        if (r108 >= r105.size()) goto L21;
        r104 = (RenderTree) ListProtector.get(r105, r108);
    L21:
        return new Pair(r107, r104);
    L16:
        r107 = null;
    L23:
        return new Pair(null, null);
    L7:
        r102 = -1;
        goto L8
    }

    public final int getDepth() {
        ArrayList<RenderTree> r100 = this.children;
        int r101 = 0;
        if (r100 == null) goto L8;
        Iterator<T> r102 = r100.iterator();
    L6:
        if (r102.hasNext() == false) goto L8;
        r101 = Math.max(r101, ((RenderTree) r102.next()).getDepth());
    L8:
        RenderItem r103 = this.current;
        if (r103 == null) goto L11;
        String r104 = r103.getType();
    L13:
        if (TextUtils.equals(r104, "BITABLE_FOLDER") == false) goto L17;
        return Math.max(1, r101) + 1;
    L17:
        return r101 + 1;
    L11:
        r104 = null;
        goto L13
    }

    public final boolean isRoot() {
        RenderItem r100 = this.current;
        if (r100 == null) goto L5;
        String r101 = r100.getId();
    L7:
        return TextUtils.equals(r101, ROOT);
    L5:
        r101 = null;
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

    public static final /* synthetic */ void access$setROOT$cp(String r100) {
        ROOT = r100;
    }

    public static final /* synthetic */ void access$setTAG$cp(String r100) {
        TAG = r100;
    }

    public final void checkTreeParent(boolean r100) {
        if (this.parentDirty == true) goto L5;
        if (r100 == true) goto L5;
        return;
    L5:
        this.parentDirty = false;
        ArrayList<RenderTree> r101 = this.children;
        if (r101 == null) goto L13;
        Iterator<T> r102 = r101.iterator();
    L9:
        if (r102.hasNext() == false) goto L14;
        RenderTree r103 = (RenderTree) r102.next();
        r103.parent = this;
        r103.checkTreeParent(true);
        goto L9
    L14:
        return;
    }

    public final RenderTree findTree(String r100) {
        Intrinsics.checkNotNullParameter(r100, "itemId");
        RenderItem r101 = this.current;
        if (r101 == null) goto L5;
        String r102 = r101.getId();
    L7:
        if (TextUtils.equals(r102, r100) == false) goto L9;
        return this;
    L9:
        ArrayList<RenderTree> r103 = this.children;
        if (r103 == null) goto L17;
        Iterator<T> r104 = r103.iterator();
    L13:
        if (r104.hasNext() == false) goto L17;
        RenderTree r105 = ((RenderTree) r104.next()).findTree(r100);
        if (r105 == null) goto L13;
        return r105;
    L17:
        return null;
    L5:
        r102 = null;
        goto L7
    }

    public final List<String> getParentIdList(String r100) {
        Intrinsics.checkNotNullParameter(r100, "id");
        checkTreeParent$default(this, false, 1, null);
        ArrayList r101 = new ArrayList();
        RenderTree r102 = findTree(r100);
    L3:
        if (r102 == null) goto L10;
        RenderItem r103 = r102.current;
        if (r103 == null) goto L9;
        String r104 = r103.getId();
        if (r104 == null) goto L9;
        r101.add(r104);
    L9:
        r102 = r102.parent;
        goto L3
    L10:
        return r101;
    }

    public final void setChildren(ArrayList<RenderTree> r100) {
        this.children = r100;
    }

    public final void setCurrent(RenderItem r100) {
        this.current = r100;
    }

    public final void setInSearch(Boolean r100) {
        this.inSearch = r100;
    }

    public final void setParent(RenderTree r100) {
        this.parent = r100;
    }

    public final void setParentDirty(boolean r100) {
        this.parentDirty = r100;
    }

    public final void setRenderItemList(ArrayList<RenderItem> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.renderItemList = r100;
    }

    public final void setSearchCollapsedSet(HashSet<String> r100) {
        this.searchCollapsedSet = r100;
    }

    public final void setSearchMark(Boolean r100) {
        this.searchMark = r100;
    }

    public final void toggleSearchState(boolean r100) {
        this.inSearch = Boolean.valueOf(r100);
    }

    private final List<RenderItem> genRenderItemListInSearch(d r100, int r101) {
        ArrayList<RenderItem> r102 = new ArrayList();
        if (Intrinsics.areEqual(this.searchMark, Boolean.TRUE) == false) goto L10;
        RenderItem r103 = this.current;
        if (r103 == null) goto L10;
        if (isRoot() == true) goto L10;
        r102.add(r103);
    L10:
        if (isRoot() == true) goto L24;
        RenderItem r104 = this.current;
        if (r104 == null) goto L14;
        String r105 = r104.getId();
    L16:
        if (TextUtils.isEmpty(r105) == true) goto L30;
        RenderItem r106 = this.current;
        if (r106 == null) goto L21;
        String r107 = r106.getId();
        if (r107 == null) goto L21;
    L23:
        if (r100.q(r107) == true) goto L30;
    L21:
        r107 = "";
    L30:
        this.renderItemList = r102;
        return r102;
    L14:
        r105 = null;
    L24:
        ArrayList<RenderTree> r108 = this.children;
        if (r108 == null) goto L30;
        Iterator<T> r109 = r108.iterator();
    L28:
        if (r109.hasNext() == false) goto L30;
        r102.addAll(((RenderTree) r109.next()).genRenderItemList(r100, r101 + 1, true));
        goto L28
    }

    public final void search(Function1<? super String, Boolean> r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "condition");
        Boolean r102 = null;
        checkTreeParent$default(this, false, 1, null);
        if (r101 == true) goto L5;
        clearMark();
    L5:
        RenderItem r103 = this.current;
        if (r103 == null) goto L8;
        r102 = Boolean.valueOf(r100.invoke(r103.getId()).booleanValue());
    L8:
        Boolean r104 = Boolean.TRUE;
        if (Intrinsics.areEqual(r102, r104) == false) goto L11;
        markParent();
        markChildren();
        this.searchMark = r104;
    L11:
        ArrayList<RenderTree> r105 = this.children;
        if (r105 == null) goto L17;
        Iterator<T> r106 = r105.iterator();
    L15:
        if (r106.hasNext() == false) goto L19;
        ((RenderTree) r106.next()).search(r100, true);
        goto L15
    L19:
        return;
    }

    public final List<RenderItem> genRenderItemList(d r100, int r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r100, "collapsedSet");
        if (Intrinsics.areEqual(this.inSearch, Boolean.TRUE) == true) goto L35;
        if (r111 == true) goto L35;
        ArrayList<RenderItem> r112 = new ArrayList();
        RenderItem r101 = this.current;
        if (r101 == null) goto L12;
        r101.setLevel(r110);
        if (isRoot() == true) goto L12;
        r112.add(r101);
    L12:
        if (isRoot() == true) goto L26;
        RenderItem r102 = this.current;
        if (r102 == null) goto L16;
        String r103 = r102.getId();
    L18:
        if (TextUtils.isEmpty(r103) == true) goto L32;
        RenderItem r104 = this.current;
        if (r104 == null) goto L23;
        String r105 = r104.getId();
        if (r105 == null) goto L23;
    L25:
        if (r100.q(r105) == true) goto L32;
    L23:
        r105 = "";
    L32:
        this.renderItemList = r112;
        return r112;
    L16:
        r103 = null;
    L26:
        ArrayList<RenderTree> r106 = this.children;
        if (r106 == null) goto L32;
        Iterator<T> r107 = r106.iterator();
    L30:
        if (r107.hasNext() == false) goto L32;
        r112.addAll(genRenderItemList$default((RenderTree) r107.next(), r100, r110 + 1, false, 4, null));
    L35:
        return genRenderItemListInSearch(r100, r110);
    }

    public final boolean moveTree(String r110, String r111, int r112) {
        Intrinsics.checkNotNullParameter(r110, "fromId");
        Intrinsics.checkNotNullParameter(r111, "toId");
        int r100 = 0;
        checkTreeParent$default(this, false, 1, null);
        tt5.a.d(TAG, "moveTree fromId:" + r110 + ". toId: " + r111 + ". offsetLevel:" + r112);
        RenderTree r101 = findTree(r110);
        if (r101 != null) goto L6;
        tt5.a.d(TAG, "findSourceTree error.");
        return false;
    L6:
        RenderTree r102 = findTree(r111);
        if (r102 != null) goto L10;
        tt5.a.d(TAG, "findTargetTree error.");
        return false;
    L10:
        RenderTree r103 = r101.parent;
        if (r103 == null) goto L70;
        ArrayList<RenderTree> r104 = r103.children;
        if (r104 == null) goto L70;
        Iterator<RenderTree> r105 = r104.iterator();
        int r106 = 0;
    L15:
        int r107 = -1;
        if (r105.hasNext() == false) goto L25;
        RenderItem r108 = r105.next().current;
        if (r108 == null) goto L20;
        String r109 = r108.getId();
    L22:
        if (TextUtils.equals(r109, r110) == true) goto L26;
        r106 = r106 + 1;
    L26:
        RenderTree r113 = null;
    L27:
        if (r112 >= 1) goto L33;
        RenderTree r114 = r102.parent;
        if (r114 == null) goto L30;
        r112 = r112 + 1;
        RenderTree r115 = r102;
        r102 = r114;
        r113 = r115;
        goto L27
    L30:
        tt5.a.d(TAG, "findTargetTreeByOffsetLevel error.");
        return false;
    L33:
        RenderTree r116 = r101.parent;
        if (r116 == null) goto L68;
        ArrayList<RenderTree> r117 = r116.children;
        if (r117 == null) goto L68;
        RenderTree r118 = (RenderTree) ListProtector.remove(r117, r106);
        if (r118 == null) goto L68;
        if (r113 == null) goto L63;
        RenderItem r119 = r113.current;
        if (r119 == null) goto L47;
        String r120 = r119.getId();
        if (r120 == null) goto L47;
        r111 = r120;
    L47:
        ArrayList<RenderTree> r121 = r102.children;
        if (r121 == null) goto L61;
        Iterator<RenderTree> r122 = r121.iterator();
    L51:
        if (r122.hasNext() == false) goto L60;
        RenderItem r123 = r122.next().current;
        if (r123 == null) goto L55;
        String r124 = r123.getId();
    L57:
        if (TextUtils.equals(r124, r111) == true) goto L58;
        r100 = r100 + 1;
        goto L51
    L58:
        r107 = r100;
        goto L60
    L55:
        r124 = null;
    L60:
        r100 = r107 + 1;
        goto L63
    L61:
        tt5.a.d(TAG, "findTargetIndex error.");
        return false;
    L63:
        ArrayList<RenderTree> r125 = r102.children;
        if (r125 == null) goto L66;
        ListProtector.add(r125, r100, r118);
    L66:
        r118.parent = r102;
        return true;
    L68:
        tt5.a.d(TAG, "removeItem empty.");
        return false;
    L20:
        r109 = null;
        goto L22
    L25:
        r106 = -1;
    L70:
        tt5.a.d(TAG, "findSourceIndex error.");
        return false;
    }

    public static /* synthetic */ void checkTreeParent$default(RenderTree r100, boolean r101, int r102, Object r103) {
        if (r103 != null) goto L9;
        if ((r102 & 1) == 0) goto L6;
        r101 = false;
    L6:
        r100.checkTreeParent(r101);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: checkTreeParent");
    }

    public static /* synthetic */ List genRenderItemListInSearch$default(RenderTree r100, d r101, int r102, int r103, Object r104) {
        if (r104 != null) goto L9;
        if ((r103 & 2) == 0) goto L7;
        r102 = 1;
    L7:
        return r100.genRenderItemListInSearch(r101, r102);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: genRenderItemListInSearch");
    }

    public static /* synthetic */ void search$default(RenderTree r100, Function1 r101, boolean r102, int r103, Object r104) {
        if (r104 != null) goto L9;
        if ((r103 & 2) == 0) goto L6;
        r102 = false;
    L6:
        r100.search(r101, r102);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: search");
    }

    public static /* synthetic */ List genRenderItemList$default(RenderTree r100, d r101, int r102, boolean r103, int r104, Object r105) {
        if (r105 != null) goto L12;
        if ((r104 & 2) == 0) goto L7;
        r102 = 0;
    L7:
        if ((r104 & 4) == 0) goto L10;
        r103 = false;
    L10:
        return r100.genRenderItemList(r101, r102, r103);
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: genRenderItemList");
    }
}
