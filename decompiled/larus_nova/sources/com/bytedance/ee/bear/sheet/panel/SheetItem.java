package com.bytedance.ee.bear.sheet.panel;

import android.text.TextUtils;
import com.bytedance.ee.util.io.NonProguard;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes18.dex */
public class SheetItem implements NonProguard {
    private static final int NON_VALUE = -1;
    protected boolean adminLimit;
    protected boolean enable;
    protected String groupId;
    protected GroupPosition groupPosition;
    protected boolean hasSubPanel;
    protected String iconKey;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    protected String f238123id;
    protected String info;
    protected SheetItem[] items;
    protected String[] list;
    protected int max;
    protected int min;
    protected boolean selected;
    protected String title;
    protected String type;
    protected String value;

    public static final enum GroupPosition extends Enum<GroupPosition> {
        public static final GroupPosition BOTTOM = null;
        public static final GroupPosition CENTER = null;
        public static final GroupPosition SINGLE = null;
        public static final GroupPosition TOP = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ GroupPosition[] f238124a = null;

        static {
            GroupPosition r100 = new GroupPosition("SINGLE", 0);
            SINGLE = r100;
            GroupPosition r101 = new GroupPosition("TOP", 1);
            TOP = r101;
            GroupPosition r102 = new GroupPosition("CENTER", 2);
            CENTER = r102;
            GroupPosition r103 = new GroupPosition("BOTTOM", 3);
            BOTTOM = r103;
            f238124a = new GroupPosition[]{r100, r101, r102, r103};
        }

        public static GroupPosition[] values() {
            return (GroupPosition[]) f238124a.clone();
        }

        public static GroupPosition valueOf(String r100) {
            return (GroupPosition) r27.a.a(GroupPosition.class, r100);
        }

        public GroupPosition(String r100, int r101) {
            super(r100, r101);
        }
    }

    public int getCurrentIndex() {
        return indexOf(this.value);
    }

    public String toString() {
        return "SheetItem{id='" + this.f238123id + "', title='" + this.title + "', selected=" + this.selected + ", enable=" + this.enable + ", min=" + this.min + ", max=" + this.max + ", value='" + this.value + "', list=" + Arrays.toString(this.list) + ", items=" + Arrays.toString(this.items) + ", adminLimit=" + this.adminLimit + ", groupId=" + this.groupId + "', groupPosition=" + this.groupPosition + '}';
    }

    public int valueRange() {
        String[] r100 = this.list;
        if (r100 == null) goto L7;
        return r100.length;
    L7:
        return (this.max - this.min) + 1;
    }

    public SheetItem() {
        this.min = -1;
        this.max = -1;
        this.groupPosition = GroupPosition.SINGLE;
    }

    public int hashCode() {
        int r100 = 0;
        if (getId() == null) goto L5;
        int r101 = getId().hashCode();
    L6:
        int r102 = r101 * 31;
        if (getTitle() == null) goto L9;
        int r103 = getTitle().hashCode();
    L10:
        int r104 = (((((((((((r102 + r103) * 31) + (isSelected() ? 1 : 0)) * 31) + (isEnable() ? 1 : 0)) * 31) + (isAdminLimit() ? 1 : 0)) * 31) + getMin()) * 31) + getMax()) * 31;
        if (getValue() == null) goto L13;
        int r105 = getValue().hashCode();
    L14:
        int r106 = (((((r104 + r105) * 31) + Arrays.hashCode(getList())) * 31) + Arrays.hashCode(getItems())) * 31;
        if (getGroupId() == null) goto L18;
        r100 = getGroupId().hashCode();
    L18:
        return r106 + r100;
    L13:
        r105 = 0;
        goto L14
    L9:
        r103 = 0;
        goto L10
    L5:
        r101 = 0;
        goto L6
    }

    public String getGroupId() {
        return this.groupId;
    }

    public GroupPosition getGroupPosition() {
        return this.groupPosition;
    }

    public String getIconKey() {
        return this.iconKey;
    }

    public String getId() {
        return this.f238123id;
    }

    public String getInfo() {
        return this.info;
    }

    public SheetItem[] getItems() {
        return this.items;
    }

    public String[] getList() {
        return this.list;
    }

    public int getMax() {
        return this.max;
    }

    public int getMin() {
        return this.min;
    }

    public String getTitle() {
        return this.title;
    }

    public String getType() {
        return this.type;
    }

    public String getValue() {
        return this.value;
    }

    public boolean isAdminLimit() {
        return this.adminLimit;
    }

    public boolean isEnable() {
        return this.enable;
    }

    public boolean isHasSubPanel() {
        return this.hasSubPanel;
    }

    public boolean isSelected() {
        return this.selected;
    }

    public static void sortByGroupId(SheetItem[] r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.length <= 1) goto L35;
        LinkedHashMap r101 = new LinkedHashMap();
        int r102 = r100.length;
        int r103 = 0;
        int r104 = 0;
    L7:
        if (r104 >= r102) goto L22;
        SheetItem r105 = r100[r104];
        if (TextUtils.isEmpty(r105.groupId) == false) goto L11;
        r105.setGroupId(r105.f238123id);
    L11:
        List r106 = (List) r101.get(r105.groupId);
        if (r106 != null) goto L15;
        ArrayList r107 = new ArrayList();
        r107.add(r105);
        r101.put(r105.groupId, r107);
    L21:
        r104 = r104 + 1;
        goto L7
    L15:
        if (r106.size() != 1) goto L18;
        ((SheetItem) ListProtector.get(r106, 0)).setGroupPosition(GroupPosition.TOP);
    L18:
        if (r106.size() <= 1) goto L20;
        ((SheetItem) ListProtector.get(r106, r106.size() - 1)).setGroupPosition(GroupPosition.CENTER);
    L20:
        r105.setGroupPosition(GroupPosition.BOTTOM);
        r106.add(r105);
        goto L21
    L22:
        Iterator r108 = r101.entrySet().iterator();
    L24:
        if (r108.hasNext() == false) goto L36;
        Iterator r109 = ((List) ((Map.Entry) r108.next()).getValue()).iterator();
    L27:
        if (r109.hasNext() == false) goto L24;
        r100[r103] = (SheetItem) r109.next();
        r103 = r103 + 1;
        goto L27
    L36:
        return;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SheetItem) == true) goto L8;
        return false;
    L8:
        SheetItem r101 = (SheetItem) r100;
        if (isSelected() == r101.isSelected()) goto L12;
        return false;
    L12:
        if (isEnable() == r101.isEnable()) goto L15;
        return false;
    L15:
        if (isAdminLimit() == r101.isAdminLimit()) goto L18;
        return false;
    L18:
        if (getMin() == r101.getMin()) goto L21;
        return false;
    L21:
        if (getMax() == r101.getMax()) goto L24;
        return false;
    L24:
        if (getId() == null) goto L29;
        if (getId().equals(r101.getId()) == true) goto L32;
    L30:
        return false;
    L32:
        if (getTitle() == null) goto L37;
        if (getTitle().equals(r101.getTitle()) == true) goto L40;
    L38:
        return false;
    L40:
        if (getValue() == null) goto L45;
        if (getValue().equals(r101.getValue()) == true) goto L48;
    L46:
        return false;
    L48:
        if (getGroupId() == null) goto L53;
        if (getGroupId().equals(r101.getGroupId()) == true) goto L56;
    L54:
        return false;
    L56:
        if (Arrays.equals(getList(), r101.getList()) == true) goto L59;
        return false;
    L59:
        return Arrays.equals(getItems(), r101.getItems());
    L53:
        if (r101.getGroupId() == null) goto L56;
    L45:
        if (r101.getValue() == null) goto L48;
    L37:
        if (r101.getTitle() == null) goto L40;
    L29:
        if (r101.getId() == null) goto L32;
        goto L30
    }

    public int indexOf(String r100) {
        if (this.list == null) goto L13;
        if (r100 == null) goto L13;
        int r101 = 0;
    L6:
        String[] r102 = this.list;
        if (r101 >= r102.length) goto L13;
        if (TextUtils.equals(r102[r101], r100) == true) goto L10;
        r101 = r101 + 1;
        goto L6
    L10:
        return r101;
    L13:
        if (this.min != (-1)) goto L15;
    L19:
        return -1;
    L15:
        if (this.max == (-1)) goto L19;
        return CastIntegerProtector.valueOf(r100).intValue() - this.min;
    }

    public void setAdminLimit(boolean r100) {
        this.adminLimit = r100;
    }

    public void setEnable(boolean r100) {
        this.enable = r100;
    }

    public void setGroupId(String r100) {
        this.groupId = r100;
    }

    public void setGroupPosition(GroupPosition r100) {
        this.groupPosition = r100;
    }

    public void setHasSubPanel(boolean r100) {
        this.hasSubPanel = r100;
    }

    public void setIconKey(String r100) {
        this.iconKey = r100;
    }

    public void setId(String r100) {
        this.f238123id = r100;
    }

    public void setInfo(String r100) {
        this.info = r100;
    }

    public void setItems(SheetItem[] r100) {
        this.items = r100;
    }

    public void setList(String[] r100) {
        this.list = r100;
    }

    public void setMax(int r100) {
        this.max = r100;
    }

    public void setMin(int r100) {
        this.min = r100;
    }

    public void setSelected(boolean r100) {
        this.selected = r100;
    }

    public void setTitle(String r100) {
        this.title = r100;
    }

    public void setType(String r100) {
        this.type = r100;
    }

    public void setValue(String r100) {
        this.value = r100;
    }

    public String valueAt(int r100) {
        if (r100 < 0) goto L16;
        if (r100 >= valueRange()) goto L16;
        String[] r101 = this.list;
        if (r101 != null) goto L8;
        int r102 = this.min;
        if (r102 == (-1)) goto L16;
        if (this.max == (-1)) goto L16;
        return String.valueOf(r102 + r100);
    L8:
        return r101[r100];
    L16:
        return this.value;
    }
}
