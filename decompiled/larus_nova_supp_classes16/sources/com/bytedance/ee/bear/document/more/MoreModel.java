package com.bytedance.ee.bear.document.more;

import android.text.TextUtils;
import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.ee.bear.BlockSimpleInfo;
import com.bytedance.ee.bear.share.export.BitableShareRoleMember;
import com.bytedance.ee.util.io.NonProguard;
import com.larksuite.framework.utils.CollectionUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class MoreModel implements NonProguard {
    private String[] badges;
    private Bitable bitable;
    private String[] disables;
    private Enables enables;
    private String[] invisibles;
    private Minutes minutes;
    private Map<String, DisableInfo> newDisables;
    private String[] switchOn;

    public static class AiSummary implements NonProguard {

        @JSONField(name = "tag_info")
        private TagInfo tagInfo;

        public AiSummary() {
        }

        public TagInfo getTagInfo() {
            return this.tagInfo;
        }

        public void setTagInfo(TagInfo r1) {
            this.tagInfo = r1;
        }
    }

    public static class Bitable implements NonProguard {
        private BitableProAccessConfig accessConfig;
        private ArrayList<BlockSimpleInfo> blocks;
        private boolean isPro;
        private ArrayList<BitableShareRoleMember> members;
        private ArrayList<String> roleIds;
        private ArrayList<BlockSimpleInfo> tables;

        public Bitable() {
        }

        public ArrayList<BlockSimpleInfo> getBlocks() {
            ArrayList<BlockSimpleInfo> r0 = this.blocks;
            if (r0 == null) goto L5;
            return r0;
        L5:
            return new ArrayList();
        }

        public ArrayList<BlockSimpleInfo> getTables() {
            ArrayList<BlockSimpleInfo> r0 = this.tables;
            if (r0 == null) goto L5;
            return r0;
        L5:
            return new ArrayList();
        }

        public boolean isProAccessConfigBindRole() {
            BitableProAccessConfig r0 = this.accessConfig;
            if (r0 != null) goto L5;
            return false;
        L5:
            if (r0.getDefaultConfig() == null) goto L16;
            int r1 = this.accessConfig.getDefaultConfig().getAccessStrategy();
            String r2 = this.accessConfig.getDefaultConfig().getRoleId();
            if (r1 == 1) goto L9;
            return false;
        L9:
            if (TextUtils.isEmpty(r2) == false) goto L11;
            return false;
        L11:
            if (CollectionUtils.isEmpty(this.roleIds) == false) goto L13;
            return false;
        L13:
            return this.roleIds.contains(r2);
        L16:
            return false;
        }

        public BitableProAccessConfig getAccessConfig() {
            return this.accessConfig;
        }

        public ArrayList<BitableShareRoleMember> getMembers() {
            return this.members;
        }

        public ArrayList<String> getRoleIds() {
            return this.roleIds;
        }

        public boolean isPro() {
            return this.isPro;
        }

        public void setAccessConfig(BitableProAccessConfig r1) {
            this.accessConfig = r1;
        }

        public void setBlocks(ArrayList<BlockSimpleInfo> r1) {
            this.blocks = r1;
        }

        public void setMembers(ArrayList<BitableShareRoleMember> r1) {
            this.members = r1;
        }

        public void setPro(boolean r1) {
            this.isPro = r1;
        }

        public void setRoleIds(ArrayList<String> r1) {
            this.roleIds = r1;
        }

        public void setTables(ArrayList<BlockSimpleInfo> r1) {
            this.tables = r1;
        }
    }

    public static class BitableProAccessConfig implements NonProguard {
        private BitableProDefaultConfig defaultConfig;

        public BitableProAccessConfig() {
        }

        public BitableProDefaultConfig getDefaultConfig() {
            return this.defaultConfig;
        }

        public void setDefaultConfig(BitableProDefaultConfig r1) {
            this.defaultConfig = r1;
        }
    }

    public static class BitableProDefaultConfig implements NonProguard {
        public static final int ACCESS_STRATEGY_BIND_ROLE = 1;
        private int accessStrategy;
        private String roleId;

        public BitableProDefaultConfig() {
        }

        public int getAccessStrategy() {
            return this.accessStrategy;
        }

        public String getRoleId() {
            return this.roleId;
        }

        public void setAccessStrategy(int r1) {
            this.accessStrategy = r1;
        }

        public void setRoleId(String r1) {
            this.roleId = r1;
        }
    }

    public static class DisableInfo implements NonProguard {
        public String text;

        public DisableInfo() {
            this.text = "";
        }
    }

    public static class Enables implements NonProguard {

        @JSONField(name = "ai_summary")
        private AiSummary aiSummary;

        public Enables() {
        }

        public AiSummary getAiSummary() {
            return this.aiSummary;
        }

        public void setAiSummary(AiSummary r1) {
            this.aiSummary = r1;
        }
    }

    public static class Minutes implements NonProguard {

        @JSONField(name = "isAudioMinutes")
        private boolean audioMinutes;
        private boolean hasAudio;
        private String token;

        public Minutes() {
        }

        public boolean getHasAudio() {
            return this.hasAudio;
        }

        public String getToken() {
            return this.token;
        }

        public boolean isAudioMinutes() {
            return this.audioMinutes;
        }

        public void setAudioMinutes(boolean r1) {
            this.audioMinutes = r1;
        }

        public void setHasAudio(boolean r1) {
            this.hasAudio = r1;
        }

        public void setToken(String r1) {
            this.token = r1;
        }
    }

    public static class TagInfo implements NonProguard {
        private String text;

        public TagInfo() {
        }

        public String getText() {
            return this.text;
        }

        public void setText(String r1) {
            this.text = r1;
        }
    }

    public MoreModel() {
    }

    public Bitable getBitable() {
        Bitable r0 = this.bitable;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return new Bitable();
    }

    public Map<String, String> getDisableReasons() {
        HashMap r0 = new HashMap();
        Map<String, DisableInfo> r1 = this.newDisables;
        if (r1 != null) goto L5;
        return r0;
    L5:
        Iterator<Map.Entry<String, DisableInfo>> r2 = r1.entrySet().iterator();
    L7:
        if (r2.hasNext() == false) goto L9;
        Map.Entry<String, DisableInfo> r3 = r2.next();
        r0.put(r3.getKey(), r3.getValue().text);
        goto L7
    L9:
        return r0;
    }

    public Minutes getMinutes() {
        Minutes r0 = this.minutes;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return new Minutes();
    }

    public String toString() {
        return "MoreData{badges=" + Arrays.toString(this.badges) + ", disable=" + Arrays.toString(this.disables) + '}';
    }

    public String[] getBadges() {
        return this.badges;
    }

    public String[] getDisables() {
        return this.disables;
    }

    public Enables getEnables() {
        return this.enables;
    }

    public String[] getInvisibles() {
        return this.invisibles;
    }

    public String[] getSwitchOn() {
        return this.switchOn;
    }

    public boolean isItemDisabled(String r6) {
        String[] r0 = this.disables;
        if (r0 != null) goto L5;
    L15:
        return false;
    L5:
        if (r0.length <= 0) goto L15;
        if (TextUtils.isEmpty(r6) == true) goto L15;
        String[] r1 = this.disables;
        int r2 = r1.length;
        int r3 = 0;
    L9:
        if (r3 >= r2) goto L15;
        if (r6.equals(r1[r3]) == true) goto L12;
        r3 = r3 + 1;
        goto L9
    L12:
        return true;
    }

    public boolean isItemInvisible(String r6) {
        String[] r0 = this.invisibles;
        if (r0 != null) goto L5;
    L15:
        return false;
    L5:
        if (r0.length <= 0) goto L15;
        if (TextUtils.isEmpty(r6) == true) goto L15;
        String[] r1 = this.invisibles;
        int r2 = r1.length;
        int r3 = 0;
    L9:
        if (r3 >= r2) goto L15;
        if (r6.equals(r1[r3]) == true) goto L12;
        r3 = r3 + 1;
        goto L9
    L12:
        return true;
    }

    public void setBadges(String[] r1) {
        this.badges = r1;
    }

    public void setBitable(Bitable r1) {
        this.bitable = r1;
    }

    public void setDisables(String[] r1) {
        this.disables = r1;
    }

    public void setEnables(Enables r1) {
        this.enables = r1;
    }

    public void setInvisibles(String[] r1) {
        this.invisibles = r1;
    }

    public void setMinutes(Minutes r1) {
        this.minutes = r1;
    }

    public void setNewDisables(Map<String, DisableInfo> r1) {
        this.newDisables = r1;
    }

    public void setSwitchOn(String[] r1) {
        this.switchOn = r1;
    }

    public boolean shouldShowBadges(String r6) {
        String[] r0 = this.badges;
        if (r0 != null) goto L5;
    L15:
        return false;
    L5:
        if (r0.length <= 0) goto L15;
        if (TextUtils.isEmpty(r6) == true) goto L15;
        String[] r1 = this.badges;
        int r2 = r1.length;
        int r3 = 0;
    L9:
        if (r3 >= r2) goto L15;
        if (r6.equals(r1[r3]) == true) goto L12;
        r3 = r3 + 1;
        goto L9
    L12:
        return true;
    }
}
