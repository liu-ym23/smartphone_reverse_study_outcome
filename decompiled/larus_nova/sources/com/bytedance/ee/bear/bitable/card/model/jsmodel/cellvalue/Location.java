package com.bytedance.ee.bear.bitable.card.model.jsmodel.cellvalue;

import com.bytedance.ee.bear.bitable.card.model.stmodel.cell.PoiInfo;
import com.bytedance.ee.util.io.NonProguard;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes15.dex */
public class Location implements NonProguard {
    public List<LocationItem> locations;

    public static class LocationItem implements NonProguard {
        PoiInfo poiInfo;

        public String toString() {
            return "LocationItem{poiInfo=" + this.poiInfo + '}';
        }

        public LocationItem() {
        }

        public PoiInfo getPoiInfo() {
            return this.poiInfo;
        }

        public LocationItem(PoiInfo r100) {
            this.poiInfo = r100;
        }

        public void setPoiInfo(PoiInfo r100) {
            this.poiInfo = r100;
        }
    }

    public String toString() {
        return "Location{locations=" + this.locations + '}';
    }

    public Location() {
    }

    public Location(PoiInfo r100) {
        ArrayList r101 = new ArrayList();
        this.locations = r101;
        r101.add(new LocationItem(r100));
    }

    public Location(List<LocationItem> r100) {
        this.locations = r100;
    }
}
