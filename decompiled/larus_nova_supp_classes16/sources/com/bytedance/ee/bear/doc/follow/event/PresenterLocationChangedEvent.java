package com.bytedance.ee.bear.doc.follow.event;

import com.bytedance.ee.util.io.NonProguard;
import du5.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class PresenterLocationChangedEvent implements ContentEvent {
    public Location follower;
    public Location presenter;

    public static class Location implements NonProguard {
        public String space;
        public double x;
        public double y;

        public Location() {
        }

        public String toString() {
            return "Location{x=" + this.x + ", y=" + this.y + ", space='" + b.g(this.space) + "'}";
        }

        public String getSpace() {
            return this.space;
        }

        public double getX() {
            return this.x;
        }

        public double getY() {
            return this.y;
        }

        public void setSpace(String r1) {
            this.space = r1;
        }

        public void setX(double r1) {
            this.x = r1;
        }

        public void setY(double r1) {
            this.y = r1;
        }
    }

    public PresenterLocationChangedEvent() {
    }

    public String toString() {
        return "PresenterLocationChangedEvent{presenter=" + this.presenter.toString() + ", follower=" + this.follower.toString() + '}';
    }

    public Location getFollower() {
        return this.follower;
    }

    public Location getPresenter() {
        return this.presenter;
    }

    public void setFollower(Location r1) {
        this.follower = r1;
    }

    public void setPresenter(Location r1) {
        this.presenter = r1;
    }
}
