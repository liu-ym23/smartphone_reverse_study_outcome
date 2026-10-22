package com.bytedance.ee.bear.atfinder;

import com.bytedance.ee.bear.at.AtObject;
import com.bytedance.ee.util.io.NonProguard;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes15.dex */
public class AtFinderResultList implements NonProguard {
    private DATA data;

    public static class DATA implements Serializable {
        private ENTITIES entities;
        private List<AtObject> result_list;

        public DATA() {
        }

        public String toString() {
            return "DATA{result_list=" + this.result_list + ", entities=" + this.entities + '}';
        }

        public ENTITIES getEntities() {
            return this.entities;
        }

        public List<AtObject> getResult_list() {
            return this.result_list;
        }

        public void setEntities(ENTITIES r100) {
            this.entities = r100;
        }

        public void setResult_list(List<AtObject> r100) {
            this.result_list = r100;
        }
    }

    public static class ENTITIES implements Serializable {
        private Map<String, AtObject> chats;
        private Map<String, AtObject> groups;
        private Map<String, AtObject> notes;
        private Map<String, AtObject> users;

        public ENTITIES() {
        }

        public String toString() {
            return "ENTITIES{}";
        }

        public Map<String, AtObject> getChats() {
            return this.chats;
        }

        public Map<String, AtObject> getGroups() {
            return this.groups;
        }

        public Map<String, AtObject> getNotes() {
            return this.notes;
        }

        public Map<String, AtObject> getUsers() {
            return this.users;
        }

        public void setChats(Map<String, AtObject> r100) {
            this.chats = r100;
        }

        public void setGroups(Map<String, AtObject> r100) {
            this.groups = r100;
        }

        public void setNotes(Map<String, AtObject> r100) {
            this.notes = r100;
        }

        public void setUsers(Map<String, AtObject> r100) {
            this.users = r100;
        }
    }

    public String toString() {
        return "AtFinderResultList{}";
    }

    public AtFinderResultList() {
    }

    public DATA getData() {
        return this.data;
    }

    public AtFinderResultList(DATA r100) {
        this.data = r100;
    }

    public void setData(DATA r100) {
        this.data = r100;
    }
}
