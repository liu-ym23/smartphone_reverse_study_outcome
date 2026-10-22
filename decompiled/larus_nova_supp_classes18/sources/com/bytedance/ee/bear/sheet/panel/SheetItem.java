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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class SheetItem implements NonProguard {
    private static final int NON_VALUE = -1;
    protected boolean adminLimit;
    protected boolean enable;
    protected String groupId;
    protected GroupPosition groupPosition;
    protected boolean hasSubPanel;
    protected String iconKey;
    protected String id;
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
        public static final /* synthetic */ GroupPosition[] a = null;

        static {
            GroupPosition r0 = new GroupPosition("SINGLE", 0);
            SINGLE = r0;
            GroupPosition r1 = new GroupPosition("TOP", 1);
            TOP = r1;
            GroupPosition r3 = new GroupPosition("CENTER", 2);
            CENTER = r3;
            GroupPosition r5 = new GroupPosition("BOTTOM", 3);
            BOTTOM = r5;
            a = new GroupPosition[]{r0, r1, r3, r5};
        }

        public static GroupPosition[] values() {
            return (GroupPosition[]) a.clone();
        }

        public static GroupPosition valueOf(String r1) {
            return (GroupPosition) r27.a.a(GroupPosition.class, r1);
        }

        public GroupPosition(String r1, int r2) {
            super(r1, r2);
        }
    }

    public int getCurrentIndex() {
        return indexOf(this.value);
    }

    public String toString() {
        return "SheetItem{id='" + this.id + "', title='" + this.title + "', selected=" + this.selected + ", enable=" + this.enable + ", min=" + this.min + ", max=" + this.max + ", value='" + this.value + "', list=" + Arrays.toString(this.list) + ", items=" + Arrays.toString(this.items) + ", adminLimit=" + this.adminLimit + ", groupId=" + this.groupId + "', groupPosition=" + this.groupPosition + '}';
    }

    public int valueRange() {
        String[] r0 = this.list;
        if (r0 == null) goto L7;
        return r0.length;
    L7:
        return (this.max - this.min) + 1;
    }

    public SheetItem() {
        this.min = -1;
        this.max = -1;
        this.groupPosition = GroupPosition.SINGLE;
    }

    public int hashCode() {
        int r1 = 0;
        if (getId() == null) goto L5;
        int r0 = getId().hashCode();
    L6:
        int r2 = r0 * 31;
        if (getTitle() == null) goto L9;
        int r3 = getTitle().hashCode();
    L10:
        int r4 = (((((((((((r2 + r3) * 31) + (isSelected() ? 1 : 0)) * 31) + (isEnable() ? 1 : 0)) * 31) + (isAdminLimit() ? 1 : 0)) * 31) + getMin()) * 31) + getMax()) * 31;
        if (getValue() == null) goto L13;
        int r5 = getValue().hashCode();
    L14:
        int r6 = (((((r4 + r5) * 31) + Arrays.hashCode(getList())) * 31) + Arrays.hashCode(getItems())) * 31;
        if (getGroupId() == null) goto L18;
        r1 = getGroupId().hashCode();
    L18:
        return r6 + r1;
    L13:
        r5 = 0;
        goto L14
    L9:
        r3 = 0;
        goto L10
    L5:
        r0 = 0;
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
        return this.id;
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

    public static void sortByGroupId(SheetItem[] r9) {
        if (r9 != null) goto L4;
        return;
    L4:
        if (r9.length <= 1) goto L35;
        LinkedHashMap r0 = new LinkedHashMap();
        int r2 = r9.length;
        int r3 = 0;
        int r4 = 0;
    L7:
        if (r4 >= r2) goto L22;
        SheetItem r5 = r9[r4];
        if (TextUtils.isEmpty(r5.groupId) == false) goto L11;
        r5.setGroupId(r5.id);
    L11:
        List r6 = (List) r0.get(r5.groupId);
        if (r6 != null) goto L15;
        ArrayList r7 = new ArrayList();
        r7.add(r5);
        r0.put(r5.groupId, r7);
    L21:
        r4 = r4 + 1;
        goto L7
    L15:
        if (r6.size() != 1) goto L18;
        ((SheetItem) ListProtector.get(r6, 0)).setGroupPosition(GroupPosition.TOP);
    L18:
        if (r6.size() <= 1) goto L20;
        ((SheetItem) ListProtector.get(r6, r6.size() - 1)).setGroupPosition(GroupPosition.CENTER);
    L20:
        r5.setGroupPosition(GroupPosition.BOTTOM);
        r6.add(r5);
        goto L21
    L22:
        Iterator r1 = r0.entrySet().iterator();
    L24:
        if (r1.hasNext() == false) goto L36;
        Iterator r8 = ((List) ((Map.Entry) r1.next()).getValue()).iterator();
    L27:
        if (r8.hasNext() == false) goto L24;
        r9[r3] = (SheetItem) r8.next();
        r3 = r3 + 1;
        goto L27
    L36:
        return;
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof SheetItem) == true) goto L8;
        return false;
    L8:
        SheetItem r5 = (SheetItem) r4;
        if (isSelected() == r5.isSelected()) goto L12;
        return false;
    L12:
        if (isEnable() == r5.isEnable()) goto L15;
        return false;
    L15:
        if (isAdminLimit() == r5.isAdminLimit()) goto L18;
        return false;
    L18:
        if (getMin() == r5.getMin()) goto L21;
        return false;
    L21:
        if (getMax() == r5.getMax()) goto L24;
        return false;
    L24:
        if (getId() == null) goto L29;
        if (getId().equals(r5.getId()) == true) goto L32;
    L30:
        return false;
    L32:
        if (getTitle() == null) goto L37;
        if (getTitle().equals(r5.getTitle()) == true) goto L40;
    L38:
        return false;
    L40:
        if (getValue() == null) goto L45;
        if (getValue().equals(r5.getValue()) == true) goto L48;
    L46:
        return false;
    L48:
        if (getGroupId() == null) goto L53;
        if (getGroupId().equals(r5.getGroupId()) == true) goto L56;
    L54:
        return false;
    L56:
        if (Arrays.equals(getList(), r5.getList()) == true) goto L59;
        return false;
    L59:
        return Arrays.equals(getItems(), r5.getItems());
    L53:
        if (r5.getGroupId() == null) goto L56;
    L45:
        if (r5.getValue() == null) goto L48;
    L37:
        if (r5.getTitle() == null) goto L40;
    L29:
        if (r5.getId() == null) goto L32;
        goto L30
    }

    public int indexOf(String r4) {
        if (this.list == null) goto L13;
        if (r4 == null) goto L13;
        int r0 = 0;
    L6:
        String[] r1 = this.list;
        if (r0 >= r1.length) goto L13;
        if (TextUtils.equals(r1[r0], r4) == true) goto L10;
        r0 = r0 + 1;
        goto L6
    L10:
        return r0;
    L13:
        if (this.min != (-1)) goto L15;
    L19:
        return -1;
    L15:
        if (this.max == (-1)) goto L19;
        return CastIntegerProtector.valueOf(r4).intValue() - this.min;
    }

    public void setAdminLimit(boolean r1) {
        this.adminLimit = r1;
    }

    public void setEnable(boolean r1) {
        this.enable = r1;
    }

    public void setGroupId(String r1) {
        this.groupId = r1;
    }

    public void setGroupPosition(GroupPosition r1) {
        this.groupPosition = r1;
    }

    public void setHasSubPanel(boolean r1) {
        this.hasSubPanel = r1;
    }

    public void setIconKey(String r1) {
        this.iconKey = r1;
    }

    public void setId(String r1) {
        this.id = r1;
    }

    public void setInfo(String r1) {
        this.info = r1;
    }

    public void setItems(SheetItem[] r1) {
        this.items = r1;
    }

    public void setList(String[] r1) {
        this.list = r1;
    }

    public void setMax(int r1) {
        this.max = r1;
    }

    public void setMin(int r1) {
        this.min = r1;
    }

    public void setSelected(boolean r1) {
        this.selected = r1;
    }

    public void setTitle(String r1) {
        this.title = r1;
    }

    public void setType(String r1) {
        this.type = r1;
    }

    public void setValue(String r1) {
        this.value = r1;
    }

    public String valueAt(int r4) {
        if (r4 < 0) goto L16;
        if (r4 >= valueRange()) goto L16;
        String[] r0 = this.list;
        if (r0 != null) goto L8;
        int r1 = this.min;
        if (r1 == (-1)) goto L16;
        if (this.max == (-1)) goto L16;
        return String.valueOf(r1 + r4);
    L8:
        return r0[r4];
    L16:
        return this.value;
    }
}
